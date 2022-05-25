package com.example.app.hotel.controllers;

import com.example.app.hotel.models.Reservation;
import com.example.app.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(path = "/")
    public String save(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping(path = "/")
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    @GetMapping(path = "/{id}")
    public Optional<Reservation> get(@PathVariable int id) {
        return reservationService.getOneReservation(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@RequestBody Reservation reservation, @PathVariable int id) {
        return reservationService.updateReservation(reservation, id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        return reservationService.deleteReservation(id);
    }

}
