package abuteen.hashem.ordermanagementbackend.service.impl;

import abuteen.hashem.ordermanagementbackend.dto.ProductOrderDto;
import abuteen.hashem.ordermanagementbackend.entity.Order;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.entity.ProductOrder;
import abuteen.hashem.ordermanagementbackend.repository.OrderRepository;
import abuteen.hashem.ordermanagementbackend.repository.ProductOrderRepository;
import abuteen.hashem.ordermanagementbackend.repository.ProductRepository;
import abuteen.hashem.ordermanagementbackend.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductOrderServiceImpl implements ProductOrderService {
    final double vat = 0.17;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductOrderDto add(String userName, int orderId,ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();
        Product product = productRepository.getReferenceById(productOrderDto.getProductDto().getId());
        productOrder.setProduct(product);
        productOrder.setQuantity(productOrderDto.getQuantity());
        productOrder.setPrice(product.getPrice()*productOrder.getQuantity());
        productOrder.setVat(productOrder.getPrice()*vat);
        Order order = orderRepository.getReferenceById(orderId);
        order.getProductOrder().add(productOrder);
        return maptoProductOrderDto(productOrder);

    }

    private ProductOrderDto maptoProductOrderDto(ProductOrder productOrder) {
        ProductOrderDto productOrderDto = new ProductOrderDto();
        return productOrderDto;
    }

    @Override
    public void delete(String userName, int orderId, int productOrderId) {

    }

    @Override
    public List<ProductOrderDto> getOrderProducts(String userName, int orderId) {
        return null;
    }

    @Override
    public ProductOrderDto editOrderProducts(String userName, int orderId, ProductOrderDto productOrderDto) {
        return null;
    }
}
