package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Employee repository.
 */
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    /**
     * Find by user name optional.
     *
     * @param userName the user name
     * @return the optional
     */
    Optional<Employee> findByUserName(String userName);
}
