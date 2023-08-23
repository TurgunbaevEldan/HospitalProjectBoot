package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.Gender;

import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Patient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_gen")
    @SequenceGenerator(
            name = "patient_gen",
            sequenceName = "patient_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Gender gender;
    private String email;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private Hospital hospital;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)

    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, String phoneNumber, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }
}
