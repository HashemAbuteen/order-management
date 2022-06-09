package abuteen.hashem.ordermanagementbackend.service.impl;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.exception.NotFoundException;
import abuteen.hashem.ordermanagementbackend.repository.ProductRepository;
import abuteen.hashem.ordermanagementbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    private final double vat = 0.17;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setActive(true);
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStockable(productDto.isStockable());
        product.setVat(product.getPrice()*vat);
        productRepository.save(product);
        productDto.setId(product.getId());
        productDto.setActive(true);
        productDto.setVat(product.getVat());
        return productDto;
    }

    @Override
    public void deleteProduct(int id) {
        if(productRepository.existsById(id)){
            Product product = productRepository.getReferenceById(id);
            product.setActive(false);
            productRepository.save(product);
        }
        else
        throw new NotFoundException();
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new LinkedList<>();
        for(Product product : productList){
            productDtoList.add(mapToProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> getAllActive() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new LinkedList<>();
        for(Product product : productList){
            if(!product.isActive()){
                continue;
            }
            productDtoList.add(mapToProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public ProductDto getByID(int id) {
        if(!productRepository.existsById(id)){
            throw new NotFoundException();
        }
        return mapToProductDto(productRepository.getReferenceById(id));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if(!productRepository.existsById(productDto.getId())){
            throw new NotFoundException();
        }
        Product product = productRepository.getReferenceById(productDto.getId());
        if(productDto.getPrice()!=0){
            product.setPrice(productDto.getPrice());
            product.setVat(productDto.getPrice()*vat);
        }
        if(productDto.getName().length()>0){
            product.setName(productDto.getName());
        }
        if(productDto.getSlug().length()>0){
            product.setSlug(product.getSlug());
        }
        if(productDto.getReference().length()>0){
            product.setReference(product.getReference());
        }
        productRepository.save(product);
        return mapToProductDto(product);
    }

    public static ProductDto mapToProductDto (Product product){
        ProductDto productDto = new ProductDto();
        productDto.setActive(product.isActive());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setReference(product.getReference());
        productDto.setSlug(product.getSlug());
        productDto.setStockable(product.isStockable());
        productDto.setVat(product.getVat());
        productDto.setId(product.getId());
        return productDto;
    }
}
