package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    /**
     * Find by user name optional.
     *
     * @param userName the user name
     * @return the optional
     */
    Optional<Customer> findByUserName(String userName);
}
