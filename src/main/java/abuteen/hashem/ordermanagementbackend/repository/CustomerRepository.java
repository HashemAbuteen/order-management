package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUserName(String userName);
}
