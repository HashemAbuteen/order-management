package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
