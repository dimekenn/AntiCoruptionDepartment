package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SendMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    private long    chatId;
    private int     receptionId;
    private int     registrationId;
}
