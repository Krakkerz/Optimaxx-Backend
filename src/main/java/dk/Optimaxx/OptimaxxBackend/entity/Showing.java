package dk.Optimaxx.OptimaxxBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @OneToMany(mappedBy = "showing", fetch =FetchType.LAZY)
    private Set<Reservation> reservations = new java.util.LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    private int basePrice;
}


