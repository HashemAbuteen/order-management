package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.CustomerDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.security.UpdatePasswordRequest;

import java.util.List;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);
    void delete(int id);
    List<CustomerDto> getAll();
    List<CustomerDto> getAllActive();
    CustomerDto getByID(int id);
    CustomerDto update(CustomerDto customerDto);
    void updatePassword(String user,UpdatePasswordRequest updatePasswordRequest);
    void setPassword(int id,UpdatePasswordRequest updatePasswordRequest);

    CustomerDto getByUser(String userName);
}
