package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CitizensInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private Date    date;

    @Column(length = 4096)
    private String  time;
}
