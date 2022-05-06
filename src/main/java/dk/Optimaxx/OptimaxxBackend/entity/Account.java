package dk.Optimaxx.OptimaxxBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "account", fetch =FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations = new java.util.LinkedHashSet<>();

}


