package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.Keyboard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepo extends CrudRepository<Keyboard, Integer> {

    @Modifying
    @Query("select k.inline from Keyboard k where k.id = ?1")
    boolean isInline(int keyboardId);
}
