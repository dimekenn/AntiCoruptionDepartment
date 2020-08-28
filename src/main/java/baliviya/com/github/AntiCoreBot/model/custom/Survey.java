package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private long    chatId;

    @Column(length = 4096)
    private String  answers;

    private Date    dateAnswer;
}
