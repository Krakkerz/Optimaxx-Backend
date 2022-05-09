package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
public class SeatResponse {
    private Long id;
    private Long number;
    private Long row;
    private String type;
    private Boolean reserved;

    private SeatResponse(Seat seat) {
        this.id = seat.getId();
        this.number = seat.getSeatNumber();
        this.row = seat.getSeatRow();
        this.type = seat.getType();
        this.reserved = false;
    }

    public static SeatResponse of(Seat entity) {
        return new SeatResponse(entity);
    }

    public static List<SeatResponse> of(Collection<Seat> entities) {
        return entities.stream().map(SeatResponse::new).toList();
    }
}
