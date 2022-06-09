package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> getAllByCustomerUserNameAndDeleted(String userName , Boolean deleted);
    boolean existsByIdAndCustomerUserName(int id , String userName);
    Order getByIdAndCustomerUserName(int id, String userName);

}
