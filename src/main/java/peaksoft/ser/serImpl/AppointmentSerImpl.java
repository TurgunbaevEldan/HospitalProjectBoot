//package peaksoft.ser.serImpl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import peaksoft.entity.Appointment;
//import peaksoft.repo.AppointmentRepo;
//import peaksoft.ser.AppointmentSer;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//
//public class AppointmentSerImpl implements AppointmentSer {
//    private final AppointmentRepo appointmentRepo;
//
//    @Override
//    public void saveHospital(Appointment hospital) {
//        appointmentRepo.save(hospital);
//    }
//
//    @Override
//    public List<Appointment> getAllAppointments() {
//        return null;
//    }
//
//    @Override
//    public Appointment getAppointmentById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void deleteAppointments(Long id) {
//
//    }
//
//    @Override
//    public void updateAppointment(Long id, Appointment appointment) {
//
//    }
//}
