package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CitizensEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private long    chatId;
    private int     receptionId;
}
