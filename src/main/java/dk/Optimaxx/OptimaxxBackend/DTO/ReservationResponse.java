package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ReservationResponse {
    private Set<Seat> seats;
    private Account account;
    private Showing showing;

    public ReservationResponse(Reservation reservation) {
        this.seats = reservation.getSeats();
        this.account = reservation.getAccount();
        this.showing = reservation.getShowing();
    }

    public static List<ReservationResponse> of(List<Reservation> entities) {
        return entities.stream().map(ReservationResponse::new).toList();
    }

    public static ReservationResponse of(Reservation entity) {
        return new ReservationResponse(entity);
    }
}
