package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CitizensRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private long    chatId;
    private int     receptionId;

    @Column(length = 4096)
    private String  fullName;

    @Column(length = 4096)
    private String  question;

    @Column(length = 4096)
    private String  status;

    private Date    date;
    private Date    citizensDate;
    private String  citizensTime;
}
