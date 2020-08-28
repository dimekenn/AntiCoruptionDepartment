package baliviya.com.github.AntiCoreBot.model.standart;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private long    chatId;
    private String  phone;
    private String  fullName;

    @Column(length = 500)
    private String  username;
}
