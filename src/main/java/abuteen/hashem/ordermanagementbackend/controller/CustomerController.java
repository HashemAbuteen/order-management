package abuteen.hashem.ordermanagementbackend.controller;

import abuteen.hashem.ordermanagementbackend.dto.CustomerDto;
import abuteen.hashem.ordermanagementbackend.dto.OrderDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Customer;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.repository.CustomerRepository;
import abuteen.hashem.ordermanagementbackend.security.UpdatePasswordRequest;
import abuteen.hashem.ordermanagementbackend.service.CustomerService;
import abuteen.hashem.ordermanagementbackend.service.OrderService;
import abuteen.hashem.ordermanagementbackend.service.ProductService;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @GetMapping("/info")
    public ResponseEntity<CustomerDto> getMyInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        return ResponseEntity.ok(customerService.getByUser(userName));
    }

    @PutMapping()
    public ResponseEntity updateCustomer(@RequestBody CustomerDto customerDto){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        if(!customerDto.getUserName().equals(userName)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(customerService.update(customerDto)) ;
    }

    @PutMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody UpdatePasswordRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        customerService.updatePassword(userName, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDto> createOrder (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(orderService.create(auth.getName()));
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getAllMyOrders (){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(orderService.getAllCustomerOrders(auth.getName()));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getMyOrderById (@PathVariable int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(orderService.getByIdAndCustomer(id,auth.getName()));
    }
}
