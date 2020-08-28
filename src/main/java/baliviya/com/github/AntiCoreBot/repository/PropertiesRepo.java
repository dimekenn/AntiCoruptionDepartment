package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.standart.Properties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepo extends CrudRepository<Properties, Integer> {}
