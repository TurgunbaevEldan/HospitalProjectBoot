package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Department;
import peaksoft.ser.DepartmentSer;

@Controller
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentApi {

    private final DepartmentSer departmentSer;

    @GetMapping("/{hospitalId}")
    String getAll(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("departments", departmentSer.getAllDepartments(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "department/getAllDepartments";
    }

    @GetMapping("/create/{hospitalId}")
    String creatDepartment(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("newDepartment", new Department());
        return "department/saveDepartments";
    }

    @PostMapping("/save/{hospitalId}")
    public String save(@ModelAttribute("newDepartment") Department department,
                       @PathVariable Long hospitalId) {
        departmentSer.saveDepartment(department, hospitalId);
        return "redirect:/api/departments/{hospitalId}";
    }

    @DeleteMapping("{hospitalId}/delete/{departmentId}")
    String deleteDepartment(@PathVariable Long departmentId,
                            @PathVariable Long hospitalId) {
        departmentSer.deleteDepartmentWithIdByHospitalId(departmentId,hospitalId);
        return "redirect:/api/departments{hospitalId}";
    }

    @GetMapping("/api/departments{departmentId}")
    public String getDepartment(@PathVariable Long departmentId,
                                Model model) {
        model.addAttribute("department", departmentSer.getDepartmentById(departmentId));
        return "department/updateDepartment";
    }

    @PostMapping("/{departmentId}/update")
    public String updateDepartment(@PathVariable Long departmentId,
                                   @ModelAttribute("department") Department department) {
        departmentSer.updateDepartment(departmentId, department);
        return "redirect:/api/departments/{departmentId}";
    }
}
