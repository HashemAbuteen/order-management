package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.CustomerDto;
import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.security.UpdatePasswordRequest;

import java.util.List;

/**
 * The interface Customer service.
 */
public interface CustomerService {
    /**
     * Create customer dto.
     *
     * @param customerDto the customer dto
     * @return the customer dto
     */
    CustomerDto create(CustomerDto customerDto);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<CustomerDto> getAll();

    /**
     * Gets all active.
     *
     * @return the all active
     */
    List<CustomerDto> getAllActive();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    CustomerDto getByID(int id);

    /**
     * Update customer dto.
     *
     * @param customerDto the customer dto
     * @return the customer dto
     */
    CustomerDto update(CustomerDto customerDto);

    /**
     * Update password.
     *
     * @param user                  the user
     * @param updatePasswordRequest the update password request
     */
    void updatePassword(String user,UpdatePasswordRequest updatePasswordRequest);

    /**
     * Sets password.
     *
     * @param id                    the id
     * @param updatePasswordRequest the update password request
     */
    void setPassword(int id,UpdatePasswordRequest updatePasswordRequest);

    /**
     * Gets by user.
     *
     * @param userName the user name
     * @return the by user
     */
    CustomerDto getByUser(String userName);
}
