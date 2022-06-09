package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    Optional<Employee> findByUserName(String userName);
}
