package abuteen.hashem.ordermanagementbackend.service.impl;

import abuteen.hashem.ordermanagementbackend.dto.OrderDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.entity.Customer;
import abuteen.hashem.ordermanagementbackend.entity.Order;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.exception.NotFoundException;
import abuteen.hashem.ordermanagementbackend.repository.CustomerRepository;
import abuteen.hashem.ordermanagementbackend.repository.OrderRepository;
import abuteen.hashem.ordermanagementbackend.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto create(String userName) {
        Order order = new Order();
        order.setOrderedAt(new Date());
        order.setCustomer(customerRepository.findByUserName(userName).get());
        return mapToOrderDto(order);
    }

    private OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderedAt(order.getOrderedAt());
        orderDto.setCustomer(order.getCustomer());
        orderDto.setProductOrderList(order.getProductOrder());
        orderDto.setDeleted(false);
        return orderDto;
    }

    @Override
    public void delete(int id) {
        if(!orderRepository.existsById(id)){
            throw new NotFoundException();
        }
        Order order = orderRepository.getReferenceById(id);
        order.setDeleted(true);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new LinkedList<>();
        for(Order order : orderList){
            orderDtoList.add(mapToOrderDto(order));
        }
        return orderDtoList;
    }

    @Override
    public List<OrderDto> getAllCustomerOrders(String userName) {
        List<Order> orderList = orderRepository.getAllByCustomerUserNameAndDeleted(userName , false);
        List<OrderDto> orderDtoList = new LinkedList<>();
        for(Order order : orderList){
            orderDtoList.add(mapToOrderDto(order));
        }
        return orderDtoList;
    }

    @Override
    public OrderDto getByID(int id) {
        if(!orderRepository.existsById(id)){
            throw new NotFoundException();
        }
        Order order = orderRepository.getReferenceById(id);
        return mapToOrderDto(order);
    }

    @Override
    public OrderDto getByIdAndCustomer(int id, String userName) {
        if(!orderRepository.existsByIdAndCustomerUserName(id , userName)){
            throw new NotFoundException();
        }
        Order order = orderRepository.getByIdAndCustomerUserName(id , userName);
        return mapToOrderDto(order);
    }
}
