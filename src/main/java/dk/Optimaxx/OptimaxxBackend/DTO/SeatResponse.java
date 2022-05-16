package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;

@Data
public class SeatResponse {
    private Long id;
    private Integer number;
    private Integer row;
    private String type;
    private Boolean reserved;

    private SeatResponse(Seat seat) {
        this.id = seat.getId();
        this.number = seat.getSeatNumber();
        this.row = seat.getSeatRow();
        this.type = seat.getType();
        this.reserved = null;
    }
    private SeatResponse(Seat seat, Boolean reserved) {
        this.id = seat.getId();
        this.number = seat.getSeatNumber();
        this.row = seat.getSeatRow();
        this.type = seat.getType();
        this.reserved = reserved;
    }

    public static SeatResponse unreserved(Seat entity) {
        return new SeatResponse(entity, false);
    }

    public static List<SeatResponse> unreserved(Collection<Seat> entities) {
        return entities.stream().map(SeatResponse::unreserved).toList();
    }

    public static SeatResponse reserved(Seat entity) {
        return new SeatResponse(entity, true);
    }

    public static List<SeatResponse> reserved(Collection<Seat> entities) {
        return entities.stream().map(SeatResponse::reserved).toList();
    }

    public static SeatResponse of(Seat entity) {
        return new SeatResponse(entity);
    }

    public static List<SeatResponse> of(Collection<Seat> entities) {
        return entities.stream().map(SeatResponse::new).toList();
    }
}
