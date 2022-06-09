package abuteen.hashem.ordermanagementbackend.repository;

import abuteen.hashem.ordermanagementbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
    /**
     * Gets all by customer user name and deleted.
     *
     * @param userName the user name
     * @param deleted  the deleted
     * @return the all by customer user name and deleted
     */
    List<Order> getAllByCustomerUserNameAndDeleted(String userName , Boolean deleted);

    /**
     * Exists by id and customer user name boolean.
     *
     * @param id       the id
     * @param userName the user name
     * @return the boolean
     */
    boolean existsByIdAndCustomerUserName(int id , String userName);

    /**
     * Gets by id and customer user name.
     *
     * @param id       the id
     * @param userName the user name
     * @return the by id and customer user name
     */
    Order getByIdAndCustomerUserName(int id, String userName);


}
