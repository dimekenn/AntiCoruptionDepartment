package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.Reception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionRepo extends CrudRepository<Reception, Integer> {
    List<Reception> findAllByLangId(int langId);

    Reception findByIdAndLangId(int id, int langId);

    Reception getById(int id);
}
