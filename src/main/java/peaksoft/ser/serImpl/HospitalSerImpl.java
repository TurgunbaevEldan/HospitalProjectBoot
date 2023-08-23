package peaksoft.ser.serImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.repo.HospitalRepo;
import peaksoft.ser.HospitalSer;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalSerImpl implements HospitalSer {
    private final HospitalRepo hospitalRepo;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepo.findById(id).orElseThrow(
                () -> new NullPointerException(
                        "hospital with id " + id + " is not found"
                )
        );
    }

    @Override
    public void deleteHospital(Long id) {
        if (hospitalRepo.existsById(id)) {
            hospitalRepo.deleteById(id);
        } else throw new NullPointerException(
                "Hospital with id " + id + " doesn't exists!"
        );
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = getHospitalById(id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
        hospitalRepo.save(hospital1);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.findAll();
    }
}

