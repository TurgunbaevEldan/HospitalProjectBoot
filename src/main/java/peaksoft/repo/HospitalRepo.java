package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Hospital;

import java.util.List;
@Repository

public interface HospitalRepo extends JpaRepository <Hospital,Long> {
//    @Query("select h.name,h.address from Hospital h")
//    List<Hospital> getAllHospitals();
}
