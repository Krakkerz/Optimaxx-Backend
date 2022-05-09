package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ShowingResponse {
    private Long id;

    private ShowingResponse(Showing showing) {
    }

    public static ShowingResponse of(Showing entity) {
        return new ShowingResponse(entity);
    }

    public static List<ShowingResponse> of(Collection<Showing> entities) {
        return entities.stream().map(ShowingResponse::new).toList();
    }
}
