package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Room;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ShowingResponse {
    private Long id;
    private Room room;

    private ShowingResponse(Showing showing) {
    }

    public static ShowingResponse of(Showing entity) {
        return new ShowingResponse(entity);
    }

    public static List<ShowingResponse> of(Collection<Showing> entities) {
        return entities.stream().map(ShowingResponse::new).toList();
    }
}
