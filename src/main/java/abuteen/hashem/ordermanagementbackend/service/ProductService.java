package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(int id);
    List<ProductDto> getAll();
    List<ProductDto> getAllActive();
    ProductDto getByID(int id);
    ProductDto update(ProductDto productDto);

}
