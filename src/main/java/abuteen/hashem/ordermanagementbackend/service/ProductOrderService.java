package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductOrderService {
    ProductOrderDto add(String userName,int orderId,ProductOrderDto productOrderDto);

    void delete(String userName, int orderId, int productOrderId);

    List<ProductOrderDto> getOrderProducts(String userName, int orderId);

    ProductOrderDto editOrderProducts(String userName, int orderId, ProductOrderDto productOrderDto);
}
