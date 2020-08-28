package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.LanguageUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageUserRepo extends CrudRepository<LanguageUser, Integer> {
    LanguageUser getByChatId(long chatId);
}
