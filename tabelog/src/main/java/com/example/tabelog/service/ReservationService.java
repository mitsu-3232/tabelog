package com.example.tabelog.service;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tabelog.entity.Reservation;
import com.example.tabelog.entity.Restaurant;
import com.example.tabelog.entity.User;
import com.example.tabelog.repository.ReservationRepository;
import com.example.tabelog.repository.RestaurantRepository;
import com.example.tabelog.repository.UserRepository;


@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;  
    private final RestaurantRepository restaurantRepository;  
    private final UserRepository userRepository;  
    
    public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;  
        this.restaurantRepository = restaurantRepository;  
        this.userRepository = userRepository;  
    }    
    
    @Transactional
    public void create(Map<String, String> paymentIntentObject) { 
        Reservation reservation = new Reservation();
        
        Integer restaurantId = Integer.valueOf(paymentIntentObject.get("restaurantId"));
        Integer userId = Integer.valueOf(paymentIntentObject.get("userId"));
        
        Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
        User user = userRepository.getReferenceById(userId);   
        LocalDate reservedDate = LocalDate.parse(paymentIntentObject.get("reservedDate"));
        LocalDate reservedTime = LocalDate.parse(paymentIntentObject.get("reservedTime"));
        Integer numberOfPeople = Integer.valueOf(paymentIntentObject.get("numberOfPeople"));        
        Integer amount = Integer.valueOf(paymentIntentObject.get("amount")); 
                
        reservation.setRestaurant(restaurant);
        reservation.setUser(user);
        reservation.setReservedDate(reservedDate);
        reservation.setReservedTime(reservedTime);
        reservation.setNumberOfPeople(numberOfPeople);
        reservation.setAmount(amount);
        
        reservationRepository.save(reservation);
    }    
    
 // 予約人数が定員以下かどうかをチェックする
    public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
        return numberOfPeople <= capacity;
    }
    
}
    
    /* 宿泊料金を計算する
    public Integer calculateAmount(LocalDate reservedDate, LocalDate reservedTime, Integer price) {
        long numberOfNights = ChronoUnit.DAYS.between(reservedDate, reservedTime);
        int amount = price * (int)numberOfNights;
        return amount;
    }    
}
    */