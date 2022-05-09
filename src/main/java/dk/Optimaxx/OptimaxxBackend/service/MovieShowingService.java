package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieShowingService {
    private final ShowingRepository showingRepository;

    public List<ShowingResponse> getAllShowingsByMovieId(String movieId) {
        return ShowingResponse.of(showingRepository.getAllByMovie_Id(movieId));
    }
}
