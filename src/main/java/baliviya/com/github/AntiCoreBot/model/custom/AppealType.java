package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AppealType {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 4096)
    private String  name;

    private Integer langId;
}
