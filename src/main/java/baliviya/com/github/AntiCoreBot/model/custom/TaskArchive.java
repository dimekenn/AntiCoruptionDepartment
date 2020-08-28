package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaskArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    @Column(length = 10000)
    private String  text;

    private int     taskId;
}
