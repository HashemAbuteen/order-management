package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Product order service.
 */
@Service
public interface ProductOrderService {
    /**
     * Add product order dto.
     *
     * @param userName        the user name
     * @param orderId         the order id
     * @param productOrderDto the product order dto
     * @return the product order dto
     */
    ProductOrderDto add(String userName,int orderId,ProductOrderDto productOrderDto);

    /**
     * Delete.
     *
     * @param userName       the user name
     * @param orderId        the order id
     * @param productOrderId the product order id
     */
    void delete(String userName, int orderId, int productOrderId);

    /**
     * Gets order products.
     *
     * @param userName the user name
     * @param orderId  the order id
     * @return the order products
     */
    List<ProductOrderDto> getOrderProducts(String userName, int orderId);

    /**
     * Edit order products product order dto.
     *
     * @param userName        the user name
     * @param orderId         the order id
     * @param productOrderDto the product order dto
     * @return the product order dto
     */
    ProductOrderDto editOrderProducts(String userName, int orderId, ProductOrderDto productOrderDto);
}
