package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShowingService {
    private final ShowingRepository showingRepository;

    public List<ShowingResponse> getAllShowings() {
        return ShowingResponse.of(showingRepository.findAll());
    }

    public ShowingResponse getShowingById(Long id) {
        // TODO: Check id exists and throw custom exception if needed
        return ShowingResponse.of(showingRepository.getById(id));
    }

    public Set<Seat> getEmptySeats(Long id) {
        ShowingResponse showingResponse = getShowingById(id);
        // TODO: compare and exclude with reserved seats somewhere, but where? ;-;
        return showingResponse.getRoom().getSeats();
    }
}
