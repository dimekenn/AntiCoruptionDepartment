package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    @Column(length = 4096)
    private String  name;
    private int     langId;
}
