package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_gen")
    @SequenceGenerator(
            name = "doctor_gen",
            sequenceName = "doctor_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String position;
    private String email;
    @ManyToMany
    private List<Department> departments;
    @OneToMany(mappedBy = "doctor", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    List<Appointment> appointments;
    @ManyToOne
    private Hospital hospital;
}
