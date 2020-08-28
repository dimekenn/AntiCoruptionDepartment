package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;
    private long employeeId;
    private int  handling;

    public Employee setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee setHandling(int handling) {
        this.handling = handling;
        return this;
    }
}
