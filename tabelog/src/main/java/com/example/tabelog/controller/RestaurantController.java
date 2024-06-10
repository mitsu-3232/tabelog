package com.example.tabelog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tabelog.entity.Restaurant;
import com.example.tabelog.form.ReservationInputForm;
import com.example.tabelog.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;        
    
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;            
    }     
  
    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "area", required = false) String area,
                        @RequestParam(name = "price", required = false) String price,                        
                        @RequestParam(name = "order", required = false) String order,                        
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model) 
    {
        Page<Restaurant> restaurantPage;
                
        if (keyword != null && !keyword.isEmpty()) {
            if (order != null && order.equals("priceAsc")) {
                restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByPriceLowAsc("%" + keyword + "%", "%" + keyword + "%", pageable);
            } else {
                restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc("%" + keyword + "%", "%" + keyword + "%", pageable);
            }  
        } else if (area != null && !area.isEmpty()) {
            if (order != null && order.equals("priceAsc")) {
                restaurantPage = restaurantRepository.findByAddressLikeOrderByPriceLowAsc("%" + area + "%", pageable);
            } else {
                restaurantPage = restaurantRepository.findByAddressLikeOrderByCreatedAtDesc("%" + area + "%", pageable);
            }     
        } else if (price != null) {
        	// "0-1000"を「0」と「1000」に分けて
        	String[] prices = price.split("-");
        	Integer priceLow = Integer.parseInt(prices[0]);
        	Integer priceHigh = Integer.parseInt(prices[1]);
        	
            if (order != null && order.equals("priceAsc")) {
                restaurantPage = 
                		restaurantRepository.findByPriceLowOrPriceHighOrderByPriceLowAsc(
                				priceLow, priceHigh, pageable);
            } else {
                restaurantPage = 
                		restaurantRepository.findByPriceLowOrPriceHighOrderByCreatedAtDesc(
                				priceLow, priceHigh, pageable);
            }            
        } else {
            if (order != null && order.equals("priceAsc")) {
                restaurantPage = restaurantRepository.findAllByOrderByPriceLowAsc(pageable);
            } else {
                restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable);   
            }     
        }                
        
        model.addAttribute("restaurantPage", restaurantPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        model.addAttribute("price", price); 
        model.addAttribute("order", order);
        
        return "restaurants/index";
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        Restaurant restaurant = restaurantRepository.getReferenceById(id);
        
        model.addAttribute("restaurant", restaurant); 
        model.addAttribute("reservationInputForm", new ReservationInputForm());
        
        return "restaurants/show";
    }  
}