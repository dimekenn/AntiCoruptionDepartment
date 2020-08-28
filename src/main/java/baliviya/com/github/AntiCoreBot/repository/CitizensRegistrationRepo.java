package baliviya.com.github.AntiCoreBot.repository;

import baliviya.com.github.AntiCoreBot.model.custom.CitizensRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CitizensRegistrationRepo extends CrudRepository<CitizensRegistration, Integer> {
    CitizensRegistration findByReceptionIdAndStatus(int receptionId, String status);
    List<CitizensRegistration> findAllByReceptionIdAndStatus(int receptionId, String status);
    List<CitizensRegistration> findByDateAfterAndDateBeforeAndReceptionId(Date dateBegin, Date deadline, int receptionId);
    CitizensRegistration findById(int Id);
   // List<CitizensRegistration> getRegistrationsByTime(Date dateBegin, Date deadline, int receptionId);
}
