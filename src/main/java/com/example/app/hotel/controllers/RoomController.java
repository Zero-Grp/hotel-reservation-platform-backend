package com.example.app.hotel.controllers;

import com.example.app.hotel.models.Room;
import com.example.app.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(path = "/")
    public String save(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @GetMapping(path = "/")
    public List<Room> getAll() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/{id}")
    public Optional<Room> get(@PathVariable int id) {
        return roomService.getOneRoom(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@RequestBody Room room, @PathVariable int id) {
        return roomService.updateRoom(room, id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        return roomService.deleteRoom(id);
    }

}
