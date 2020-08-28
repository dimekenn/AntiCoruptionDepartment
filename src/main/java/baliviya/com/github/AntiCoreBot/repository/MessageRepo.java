package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Message, Integer> {

    Message findFirstByIdAndLanguageId(long id, int languageId);

    @Query("select m from Message m where m.id = ?1 and m.languageId =?2")
    Message findByIdAndLanguageId(int id, int languageId);
}
