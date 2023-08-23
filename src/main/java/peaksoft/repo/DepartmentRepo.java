package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;
import peaksoft.entity.Hospital;

import java.util.List;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {


    List<Department> findDepartmentByHospitalId(Long id);

    Hospital getHospital();
}

