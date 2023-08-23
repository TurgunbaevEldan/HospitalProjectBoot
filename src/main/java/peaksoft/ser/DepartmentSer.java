package peaksoft.ser;

import peaksoft.entity.Department;

import java.util.List;

public interface DepartmentSer {
    List<Department> getAllDepartments(Long hospitalId);
    void saveDepartment(Department department, Long hospitalId);

    Department getDepartmentById(Long id);

    void deleteDepartments(Long id);
    void updateDepartment(Long id,Department department);

    void deleteDepartmentWithIdByHospitalId(Long departmentId, Long hospitalId);
}
