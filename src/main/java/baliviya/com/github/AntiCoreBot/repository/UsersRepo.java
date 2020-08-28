package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends CrudRepository<User, Integer> {
    User        getByChatId(long chatId);
    Integer     countUserByChatId(long chatId);
    List<User>  findAll();
}
