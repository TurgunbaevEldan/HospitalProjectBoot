package peaksoft.ser;

import peaksoft.entity.Appointment;

import java.util.List;

public interface AppointmentSer {
    void saveHospital(Appointment hospital);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    void deleteAppointments(Long id);

    void updateAppointment(Long id, Appointment appointment);
}
