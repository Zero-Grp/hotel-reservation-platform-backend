package com.example.app.hotel.services;

import com.example.app.hotel.models.Reservation;
import com.example.app.hotel.models.Room;
import com.example.app.hotel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public String saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return "Reservation successfully saved";
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getOneReservation(int id) {
        return reservationRepository.findById(id);
    }

    public String updateReservation(Reservation reservation, int id) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setEndDate(reservation.getEndDate());
        existingReservation.setStatus(reservation.getStatus());
        existingReservation.setAmount(reservation.getAmount());
        reservationRepository.save(existingReservation);
        return "Reservation updated successfully";
    }

    public String deleteReservation(int id) {
        reservationRepository.deleteById(id);
        return "Reservation successfully deleted";
    }

}
