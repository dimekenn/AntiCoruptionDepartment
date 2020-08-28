package baliviya.com.github.AntiCoreBot.model.standart;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private long    chatId;

    @Column(length = 500)
    private String  comment;

    public Admin setChatId(long chatId) {
        this.chatId = chatId;
        return this;
    }

    public Admin setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
