package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
