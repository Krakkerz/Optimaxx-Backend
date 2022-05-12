package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Showing;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieShowingService {
    private final ShowingRepository showingRepository;

    public List<ShowingResponse> getAllShowingsByMovieId(String movieId) {
        return ShowingResponse.of(showingRepository.getAllByMovie_Id(movieId));
    }

    public Map<LocalDate, List<ShowingResponse>> getAllShowingsByMovieIdGroupByDate(String movieId) {
        Map<LocalDate, List<ShowingResponse>> showingsGroupedByDate = new HashMap<>();
        Set<Showing> showings = showingRepository.getAllByMovie_Id(movieId);

        for (Showing showing : showings) {
            LocalDate showingStartDate = showing.getStartTime().toLocalDate();

            if (!showingsGroupedByDate.containsKey(showingStartDate))
                showingsGroupedByDate.put(showingStartDate, new ArrayList<>());

            showingsGroupedByDate.get(showingStartDate).add(ShowingResponse.of(showing));
        }

        return showingsGroupedByDate;
    }
}
