package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Account account;
    private Set<Seat> seats = new java.util.LinkedHashSet<>();
    private Showing showing;
}
