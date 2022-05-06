package dk.Optimaxx.OptimaxxBackend.repository;

import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
