package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_tbl")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String userName;
    private String password;

}
