package peaksoft.ser;

import peaksoft.entity.Doctor;

import java.util.List;

public interface DoctorSer {
    List<Doctor>getAllDoctors(Long doctorId);
    void saveDoctors(Doctor doctor,Long doctorId);
}
