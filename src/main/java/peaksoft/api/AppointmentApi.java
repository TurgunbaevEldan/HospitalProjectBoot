//package peaksoft.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import peaksoft.entity.Appointment;
//import peaksoft.ser.AppointmentSer;
//
//@Controller
//@RequestMapping("/api/appointment")
//@RequiredArgsConstructor
//
//public class AppointmentApi {
//    private final AppointmentSer appointmentSer;
//
//    @GetMapping("/new")
//    public String createAppointment(Model model){
//        model.addAttribute("newAppointment",new Appointment());
//        return "hospital/newAppointment";
//    }
//
//    @PostMapping("/save")
//    public String saveAppointment(@ModelAttribute("newAppointment") Appointment appointment) {
//        appointmentSer.saveHospital(appointment);
//        return "redirect:/appointment";
//    }
//
//}
