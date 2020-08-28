package baliviya.com.github.AntiCoreBot.model.custom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    @Column(length = 5000)
    private String  img;

    @Column(length = 5000)
    private String  video;

    private int     idTask;

    @Column(length = 5000)
    private String  location;

    private boolean done;

    public File setDone(boolean done) {
        this.done = done;
        return this;
    }
}
