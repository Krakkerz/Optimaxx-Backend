package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.RoomResponse;
import dk.Optimaxx.OptimaxxBackend.repository.RoomRepository;
import dk.Optimaxx.OptimaxxBackend.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin
@AllArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    @GetMapping
    public List<RoomResponse> getRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomResponse getRooms(@PathVariable Long id){
        return roomService.getRoomById(id);
    }
}
