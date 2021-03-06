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
public class    Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int seatNumber;
    private int seatRow;

    @ManyToMany(mappedBy = "seats", cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations = new java.util.LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}


