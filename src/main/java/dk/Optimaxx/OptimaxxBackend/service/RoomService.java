package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.RoomResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.entity.Room;
import dk.Optimaxx.OptimaxxBackend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<RoomResponse> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();
        return RoomResponse.of(rooms);
    }

    public RoomResponse getRoomById(Long id) {
        boolean roomDoesNotExist = roomRepository.existsById(id);
        //error stuff here

        Room room = roomRepository.getById(id);
        return RoomResponse.of(room);
    }
}

