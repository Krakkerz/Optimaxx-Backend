package dk.Optimaxx.OptimaxxBackend.entity;

import dk.Optimaxx.OptimaxxBackend.DTO.ReservationRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToMany
    private Set<Seat> seats = new java.util.LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Showing showing;

    public Reservation(ReservationRequest request) {
        this.account = request.getAccount();
        this.seats = request.getSeats();
        this.showing = request.getShowing();
    }
}


