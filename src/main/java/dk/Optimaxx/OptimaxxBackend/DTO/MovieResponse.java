package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.utilities.DurationFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponse {
    private String id;
    private String title;
    private String category;
    private Integer minimumAge;
    private String duration;
    private LocalDate releaseDate;
    private Double rating;
    private String picture;
    private String trailer;
    private String tagline;
    private String plot;


    private MovieResponse(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.picture = movie.getPicture();
        this.category = movie.getCategory();
        this.trailer = movie.getTrailer();
        this.rating = movie.getRating();
        this.duration = DurationFormatter.formatDuration(movie.getDuration());
        this.plot = movie.getPlot();
    }

    public static List<MovieResponse> of(Collection<Movie> entities) {
        return entities.stream().map(MovieResponse::new).toList();
    }

    public static MovieResponse of(Movie entity) {
        return new MovieResponse(entity);
    }

}
