package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.ShowingResponse;
import dk.Optimaxx.OptimaxxBackend.repository.ShowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
