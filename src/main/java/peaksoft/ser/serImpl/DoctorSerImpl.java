package peaksoft.ser.serImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;
import peaksoft.repo.DepartmentRepo;
import peaksoft.repo.DoctorRepo;
import peaksoft.ser.DoctorSer;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class DoctorSerImpl implements DoctorSer {

    private final DoctorRepo doctorRepo;
    private final DepartmentRepo departmentRepo;


    @Override
    public List<Doctor> getAllDoctors(Long doctorId) {
        return doctorRepo.findAll() ;
    }

    @Override
    public void saveDoctors(Doctor doctor, Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow(
                () -> new NullPointerException(
                        "department with id " + departmentId + " is not found"
                )
        );

    }
}
