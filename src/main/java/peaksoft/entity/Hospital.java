package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Hospital {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hospital_gen")
    @SequenceGenerator(
            name = "hospital_gen",
            sequenceName = "hospital_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    List<Patient> patients;
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Department> departments;
    @OneToMany
    List<Appointment> appointments;

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addHospital(Department department) {
        if (department == null){
            departments = new ArrayList<>();
        }else {
            departments.add(department);
        }
    }
}
