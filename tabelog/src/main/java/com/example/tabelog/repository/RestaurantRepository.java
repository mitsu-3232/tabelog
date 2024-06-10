package com.example.tabelog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tabelog.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);
    
    public Page<Restaurant> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, Pageable pageable);  
    public Page<Restaurant> findByNameLikeOrAddressLikeOrderByPriceLowAsc(String nameKeyword, String addressKeyword, Pageable pageable);  
    public Page<Restaurant> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);
    public Page<Restaurant> findByAddressLikeOrderByPriceLowAsc(String area, Pageable pageable);
    public Page<Restaurant> findByPriceLowOrPriceHighOrderByCreatedAtDesc(Integer priceLow,Integer priceHigh, Pageable pageable);
    public Page<Restaurant> findByPriceLowOrPriceHighOrderByPriceLowAsc(Integer priceLow,Integer priceHigh, Pageable pageable); 
    public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);
    public Page<Restaurant> findAllByOrderByPriceLowAsc(Pageable pageable); 
    public List<Restaurant> findTop10ByOrderByCreatedAtDesc();
}

