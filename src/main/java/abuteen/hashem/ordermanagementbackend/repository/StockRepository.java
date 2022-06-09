package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Stock repository.
 */
public interface StockRepository extends JpaRepository<Stock, Integer> {
}
