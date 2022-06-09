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

/**
 * The type Employee controller.
 */
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

    /**
     * Create product response entity.
     *
     * @param productDto the product dto
     * @return the response entity
     */
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    /**
     * Get all products response entity.
     *
     * @return the response entity
     */
    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    /**
     * Get product by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getByID(id));
    }

    /**
     * Delete product response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(id , HttpStatus.OK);
    }

    /**
     * Update product response entity.
     *
     * @param productDto the product dto
     * @return the response entity
     */
    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(productDto)) ;
    }

    /**
     * Create stock response entity.
     *
     * @param stockDto the stock dto
     * @return the response entity
     */
    @PostMapping("/stock")
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockService.createStock(stockDto));
    }

    /**
     * Get all stocks response entity.
     *
     * @return the response entity
     */
    @GetMapping("/stock")
    public ResponseEntity<List<StockDto>> getAllStocks(){
        return ResponseEntity.ok(stockService.getAll());
    }

    /**
     * Get stock by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/stock/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable int id){
        return ResponseEntity.ok(stockService.getByID(id));
    }

    /**
     * Delete stock response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/stock/{id}")
    public ResponseEntity<Integer> deleteStock(@PathVariable int id){
        stockService.deleteStock(id);
        return new ResponseEntity<>(id , HttpStatus.OK);
    }

    /**
     * Update stock response entity.
     *
     * @param stockDto the stock dto
     * @return the response entity
     */
    @PutMapping("/stock")
    public ResponseEntity<StockDto> updateStock(@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockService.update(stockDto)) ;
    }

    /**
     * Create customer response entity.
     *
     * @param customerDto the customer dto
     * @return the response entity
     */
    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.create(customerDto));
    }

    /**
     * Get all customers response entity.
     *
     * @return the response entity
     */
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    /**
     * Get customer by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int id){
        return ResponseEntity.ok(customerService.getByID(id));
    }

    /**
     * Delete customer response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update customer response entity.
     *
     * @param customerDto the customer dto
     * @return the response entity
     */
    @PutMapping("/customer")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.update(customerDto)) ;
    }

    /**
     * Set customer password response entity.
     *
     * @param request the request
     * @param id      the id
     * @return the response entity
     */
    @PutMapping("/customer/{id}")
    public ResponseEntity setCustomerPassword(@RequestBody UpdatePasswordRequest request , @PathVariable int id){
        customerService.setPassword(id , request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get order by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id){
        return ResponseEntity.ok(orderService.getByID(id));
    }

    /**
     * Get all orders response entity.
     *
     * @return the response entity
     */
    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    /**
     * Delete order response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id){
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Test response entity.
     *
     * @return the response entity
     */
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return  ResponseEntity.ok("ok :)");
    }
}
