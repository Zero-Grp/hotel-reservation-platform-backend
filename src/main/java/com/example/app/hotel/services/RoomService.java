package com.example.app.hotel.services;

import com.example.app.hotel.models.Room;
import com.example.app.hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public String saveRoom(Room room) {
        roomRepository.save(room);
        return "Room successfully saved";
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getOneRoom(int id) {
        return roomRepository.findById(id);
    }

    public String updateRoom(Room room, int id) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        existingRoom.setTitle(room.getTitle());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setImageURL(room.getImageURL());
        roomRepository.save(existingRoom);
        return "Room updated successfully";
    }

    public String deleteRoom(int id) {
        roomRepository.deleteById(id);
        return "Room successfully deleted";
    }

}
