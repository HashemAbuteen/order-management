package abuteen.hashem.ordermanagementbackend.controller;

import abuteen.hashem.ordermanagementbackend.dto.CustomerDto;
import abuteen.hashem.ordermanagementbackend.dto.OrderDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.security.UpdatePasswordRequest;
import abuteen.hashem.ordermanagementbackend.service.CustomerService;
import abuteen.hashem.ordermanagementbackend.service.OrderService;
import abuteen.hashem.ordermanagementbackend.service.ProductService;
import abuteen.hashem.ordermanagementbackend.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getByID(id));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(id , HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(productDto)) ;
    }

    @PostMapping("/stock")
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockService.createStock(stockDto));
    }

    @GetMapping("/stock")
    public ResponseEntity<List<StockDto>> getAllStocks(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable int id){
        return ResponseEntity.ok(stockService.getByID(id));
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity<Integer> deleteStock(@PathVariable int id){
        stockService.deleteStock(id);
        return new ResponseEntity<>(id , HttpStatus.OK);
    }

    @PutMapping("/stock")
    public ResponseEntity<StockDto> updateStock(@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockService.update(stockDto)) ;
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.create(customerDto));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int id){
        return ResponseEntity.ok(customerService.getByID(id));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.update(customerDto)) ;
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity setCustomerPassword(@RequestBody UpdatePasswordRequest request , @PathVariable int id){
        customerService.setPassword(id , request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id){
        return ResponseEntity.ok(orderService.getByID(id));
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id){
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return  ResponseEntity.ok("ok :)");
    }
}
