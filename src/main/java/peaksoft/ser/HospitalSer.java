package peaksoft.ser;

import peaksoft.entity.Hospital;

import java.util.List;

public interface HospitalSer {
    void saveHospital(Hospital hospital);

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(Long id);

    void deleteHospital(Long id);

    void updateHospital(Long id, Hospital hospital);




}
