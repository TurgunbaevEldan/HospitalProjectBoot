package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Department {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_gen")
    @SequenceGenerator(
            name = "department_gen",
            sequenceName = "department_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "departments", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Doctor> doctors;
    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    private List<Appointment> appointments;
}


