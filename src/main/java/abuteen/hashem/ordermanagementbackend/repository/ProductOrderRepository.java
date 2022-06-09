package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Product order repository.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}
