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
    private Long id;
    private List<SeatResponse> seats;
    private AccountResponse account;
    private ShowingResponse showing;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();

        this.seats = reservation.getSeats() == null ? null : SeatResponse.reserved(reservation.getSeats());
        this.account = reservation.getAccount() == null ? null : AccountResponse.of(reservation.getAccount());
        this.showing = reservation.getShowing() == null ? null : ShowingResponse.of(reservation.getShowing());
    }

    public static List<ReservationResponse> of(List<Reservation> entities) {
        return entities.stream().map(ReservationResponse::new).toList();
    }

    public static ReservationResponse of(Reservation entity) {
        return new ReservationResponse(entity);
    }
}
