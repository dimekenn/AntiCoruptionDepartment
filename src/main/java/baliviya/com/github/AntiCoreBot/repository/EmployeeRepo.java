package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    List<Employee> findAllByHandling(int handlingId);
    List<Employee> findAll();
    int countAllByEmployeeId(long chatId);
    int countAllByEmployeeIdAndHandling(long chatId, int handlingId);
}
