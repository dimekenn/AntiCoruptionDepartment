package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.AppealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AppealTypeRepo extends JpaRepository<AppealType, Integer> {
    List<AppealType>        findAllByLangId(int langId);
    AppealType              findByIdAndLangId(int id, int langId);
    List<AppealType>        findAll();
    List<Integer>           findAllByIdOrderById(int id);
    void                    deleteAllById(int id);
}
