package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.Quest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepo extends CrudRepository<Quest, Integer> {
    List<Quest> findAllByLangId(int langId);
}
