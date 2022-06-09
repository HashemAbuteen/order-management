package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
