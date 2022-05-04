package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponse {
    private Long id;
    private String name;

    private MovieResponse(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
    }

    public static List<MovieResponse> of(List<Movie> entities) {
        return entities.stream().map(MovieResponse::new).toList();
    }

    public static MovieResponse of(Movie entity) {
        return new MovieResponse(entity);
    }

}
