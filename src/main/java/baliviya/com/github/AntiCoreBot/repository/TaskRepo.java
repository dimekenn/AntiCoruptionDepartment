package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer> {
    List<Task>  findAllByPeopleIdAndIdStatus(long chatId, int idStatus);
    List<Task>  findAllByDateBeginAfterAndDateBeginBefore(Date dateBegin, Date dateEnd);
    int countAllByDateBeginAfterAndDateBeginBeforeAndIdStatus(Date dateBegin, Date dateEnd, int statusId);
}
