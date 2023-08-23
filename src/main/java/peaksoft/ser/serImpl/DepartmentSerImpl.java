package peaksoft.ser.serImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Hospital;
import peaksoft.repo.DepartmentRepo;
import peaksoft.repo.HospitalRepo;
import peaksoft.ser.DepartmentSer;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class DepartmentSerImpl implements DepartmentSer {

    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;


    @Override
    public List<Department> getAllDepartments(Long hospitalId) {
        return departmentRepo.findAll();
    }

    @Override
    @Transactional
    public void saveDepartment(Department department, Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(
                () -> new NullPointerException(
                        "hospital with id " + hospitalId + " is not found"
                )
        );
        hospital.addHospital(department);
        department.setHospital(hospital);
        departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).orElseThrow(
                () -> new NullPointerException(
                        "hospital with id " + id + " is not found"
                )
        );
    }

    @Override
    public void deleteDepartments(Long id) {
        Department department = departmentRepo.findById(id).orElseThrow(()
                -> new NullPointerException("Department with id: " + id + " not found"));
        Hospital hospital = departmentRepo.getHospital();
        hospital.getDepartments().remove(department);
        departmentRepo.deleteById(id);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
//        Department department1 = getDepartmentById(id);
//        department1.setName(department.getName());
//        departmentRepo.save(department1);
        departmentRepo.saveAndFlush(department);
    }

    @Override
    public void deleteDepartmentWithIdByHospitalId(Long departmentId, Long hospitalId) {
        departmentRepo.deleteById(departmentId);
    }
}
