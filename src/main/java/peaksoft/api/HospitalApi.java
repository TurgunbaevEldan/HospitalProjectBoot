package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Hospital;
import peaksoft.ser.HospitalSer;


@Controller
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
public class HospitalApi {

    private final HospitalSer hospitalSer;

    @GetMapping
    public String getAllHospitals(Model model) {
        model.addAttribute("allHospitals", hospitalSer.getAllHospitals());
        return "hospital/getAllHospitals";
    }

    @GetMapping("/new")
    public String createHospital(Model model) {
        model.addAttribute("newHospital", new Hospital());
        return "hospital/newHospital";
    }

    @PostMapping
    public String saveHospital(@ModelAttribute("newHospital") Hospital hospital) {
        hospitalSer.saveHospital(hospital);
        return "redirect:/api/hospitals";
    }

    @GetMapping(value = "{hospitalId}/update")
    public String getHospital(@PathVariable Long hospitalId,
                              Model model) {
        model.addAttribute("hospital", hospitalSer.getHospitalById(hospitalId));
        return "hospital/updateUser";
    }

    @PostMapping("{hospitalId}/update")
    public String updateHospital(@PathVariable Long hospitalId,
                                 @ModelAttribute("hospital") Hospital hospital) {
        hospitalSer.updateHospital(hospitalId, hospital);
        return "redirect:/api/hospitals";
    }

    @GetMapping("{hospitalId}/delete")
    public String deleteHospital(@PathVariable Long hospitalId) {
        hospitalSer.deleteHospital(hospitalId);
        return "redirect:/api/hospitals";
    }

    @GetMapping("{hospitalId}/findBy")
    public String hospitalById(@PathVariable("hospitalId") Long id) {
        hospitalSer.getHospitalById(id);
        return "hospital/getAllHospitals";
    }
}
