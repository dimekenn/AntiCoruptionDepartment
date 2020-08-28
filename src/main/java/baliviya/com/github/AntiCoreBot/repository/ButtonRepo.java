package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.Button;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonRepo extends CrudRepository<Button, Integer> {
    Button  findByNameAndLangId(String buttonName, int languageId);
    Button  findByIdAndLangId(int id, int langId);
    int     countByNameAndLangId(String name, int langId);
    Button   findById(int id);
}
