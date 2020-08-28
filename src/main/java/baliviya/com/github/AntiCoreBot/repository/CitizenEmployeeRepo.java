package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.CitizensEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenEmployeeRepo extends CrudRepository<CitizensEmployee, Integer> {
    CitizensEmployee getByChatId(long chatId);
    CitizensEmployee findByReceptionId(int receptionId);

}
