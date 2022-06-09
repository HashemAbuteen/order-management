package abuteen.hashem.ordermanagementbackend.service.impl;

import abuteen.hashem.ordermanagementbackend.dto.CustomerDto;
import abuteen.hashem.ordermanagementbackend.entity.Customer;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.exception.ChangeUserNameException;
import abuteen.hashem.ordermanagementbackend.exception.IncorrectUsernameOrPasswordException;
import abuteen.hashem.ordermanagementbackend.exception.NotFoundException;
import abuteen.hashem.ordermanagementbackend.exception.UserNameIsTakenException;
import abuteen.hashem.ordermanagementbackend.repository.CustomerRepository;
import abuteen.hashem.ordermanagementbackend.repository.EmployeeRepository;
import abuteen.hashem.ordermanagementbackend.security.UpdatePasswordRequest;
import abuteen.hashem.ordermanagementbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public CustomerDto create(CustomerDto customerDto) {
        if(customerRepository.findByUserName(customerDto.getUserName()).isPresent() || employeeRepository.findByUserName(customerDto.getUserName()).isPresent())
        {
            throw new UserNameIsTakenException();
        }
        Customer customer = new Customer();
        customer.setUserName(customerDto.getUserName());
        customer.setActive(true);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBornAt(customerDto.getBornAt());
        customer.setPassword(customerDto.getPassword());
        customerDto.setPassword("");
        return customerDto;
    }

    @Override
    public void delete(int id) {
        if(customerRepository.existsById(id)){
            Customer customer = customerRepository.getReferenceById(id);
            customer.setActive(false);
            customerRepository.save(customer);
        }
        else
            throw new NotFoundException();
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new LinkedList<>();
        for(Customer customer : customerList){
            customerDtoList.add(mapToCustomerDto(customer));
        }
        return customerDtoList;
    }

    private CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setBornAt(customer.getBornAt());
        customerDto.setActive(customer.isActive());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUserName(customer.getUserName());
        customerDto.setId(customer.getId());
        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllActive() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new LinkedList<>();
        for(Customer customer : customerList){
            if(!customer.isActive()){
                continue;
            }
            customerDtoList.add(mapToCustomerDto(customer));
        }
        return customerDtoList;
    }

    @Override
    public CustomerDto getByID(int id) {
        if(!customerRepository.existsById(id)){
            throw new NotFoundException();
        }
        return mapToCustomerDto(customerRepository.getReferenceById(id));
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        if(!customerRepository.existsById(customerDto.getId())){
            throw new NotFoundException();
        }
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        if(!customer.getUserName().equals(customerDto.getUserName())){
            throw new ChangeUserNameException();
        }
        if(customerDto.getFirstName().length()>0){
            customer.setFirstName(customerDto.getFirstName());
        }
        if(customerDto.getLastName().length()>0){
            customer.setLastName(customerDto.getLastName());
        }
        return mapToCustomerDto(customer);
    }

    @Override
    public void updatePassword(String user,UpdatePasswordRequest updatePasswordRequest) {
        Optional<Customer> customer =  customerRepository.findByUserName(user);
        if(!customer.isPresent() || !customer.get().getPassword().equals(updatePasswordRequest.getOldPass())){
            throw new IncorrectUsernameOrPasswordException();
        }
        customer.get().setPassword(updatePasswordRequest.getNewPass());
        customerRepository.save(customer.get());
    }

    @Override
    public void setPassword(int id, UpdatePasswordRequest updatePasswordRequest) {
        if(!customerRepository.existsById(id) ){
            throw new IncorrectUsernameOrPasswordException();
        }
        Customer customer =  customerRepository.getReferenceById(id);
        customer.setPassword(updatePasswordRequest.getNewPass());
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto getByUser(String userName) {
        Optional<Customer> customer = customerRepository.findByUserName(userName);
        if(!customer.isPresent()){
            throw new NotFoundException();
        }
        return mapToCustomerDto(customer.get());
    }


}
