package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepo extends CrudRepository<File, Integer> {
    List<File>      findAllByIdTask(int taskId);
    Optional<File>  findByIdTask(int taskId);
}
