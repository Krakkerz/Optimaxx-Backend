package dk.Optimaxx.OptimaxxBackend.repository;

import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
