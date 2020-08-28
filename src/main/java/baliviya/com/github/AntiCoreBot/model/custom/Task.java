package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private int     idStatus;

    @Column(length = 10000)
    private String  taskText;

    private Date    dateBegin;
    private long    peopleId;

    @Column(length = 500)
    private String  appraisal;

    private int     handling;
    private int     messageId;

    @Column(length = 500)
    private String  timeTask;
}
