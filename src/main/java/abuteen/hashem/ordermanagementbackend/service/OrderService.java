package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.OrderDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;
import abuteen.hashem.ordermanagementbackend.entity.Order;

import java.util.List;

/**
 * The interface Order service.
 */
public interface OrderService {
    /**
     * Create order dto.
     *
     * @param userName the user name
     * @return the order dto
     */
    OrderDto create(String userName);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<OrderDto> getAll();

    /**
     * Gets all customer orders.
     *
     * @param UserName the user name
     * @return the all customer orders
     */
    List<OrderDto> getAllCustomerOrders(String UserName);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    OrderDto getByID(int id);

    /**
     * Gets by id and customer.
     *
     * @param id       the id
     * @param userName the user name
     * @return the by id and customer
     */
    OrderDto getByIdAndCustomer(int id , String userName);
}
