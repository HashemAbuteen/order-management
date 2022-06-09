package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;

import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {
    /**
     * Create product product dto.
     *
     * @param productDto the product dto
     * @return the product dto
     */
    ProductDto createProduct(ProductDto productDto);

    /**
     * Delete product.
     *
     * @param id the id
     */
    void deleteProduct(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<ProductDto> getAll();

    /**
     * Gets all active.
     *
     * @return the all active
     */
    List<ProductDto> getAllActive();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    ProductDto getByID(int id);

    /**
     * Update product dto.
     *
     * @param productDto the product dto
     * @return the product dto
     */
    ProductDto update(ProductDto productDto);

}
