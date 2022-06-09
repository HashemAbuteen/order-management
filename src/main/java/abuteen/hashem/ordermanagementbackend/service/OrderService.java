package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.OrderDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;
import abuteen.hashem.ordermanagementbackend.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDto create(String userName);
    void delete(int id);
    List<OrderDto> getAll();
    List<OrderDto> getAllCustomerOrders(String UserName);
    OrderDto getByID(int id);
    OrderDto getByIdAndCustomer(int id , String userName);
}
