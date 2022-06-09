package abuteen.hashem.ordermanagementbackend.security;

import abuteen.hashem.ordermanagementbackend.entity.Customer;
import abuteen.hashem.ordermanagementbackend.entity.Employee;
import abuteen.hashem.ordermanagementbackend.repository.CustomerRepository;
import abuteen.hashem.ordermanagementbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUserName(userName);

        if(employee.isPresent()){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            return new User(employee.get().getUserName(), employee.get().getPassword(), authorities);
        }
        else {
            Optional<Customer> customer = customerRepository.findByUserName(userName);
            if(customer.isPresent() && customer.get().isActive()) {
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
                return new User(customer.get().getUserName(), customer.get().getPassword(), authorities);
            }
            else{
                    throw new UsernameNotFoundException("User " + userName + " does not exist...");
                }
        }
    }
}
