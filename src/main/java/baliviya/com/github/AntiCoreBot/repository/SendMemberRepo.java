package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.SendMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMemberRepo extends CrudRepository<SendMember, Integer> {
//    void insertOrUpdate(SendMember sendMember);
    SendMember findByChatId(long chatId);
}
