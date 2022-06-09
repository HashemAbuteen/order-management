package abuteen.hashem.ordermanagementbackend.controller;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.service.ProductService;
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

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return  ResponseEntity.ok("ok :)");
    }
}
