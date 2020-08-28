package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.TaskArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskArchiveRepo extends CrudRepository<TaskArchive, Integer> {
    List<TaskArchive>       findAllByTaskId(int taskId);
    Optional<TaskArchive>   findByTaskId(int taskId);
}
