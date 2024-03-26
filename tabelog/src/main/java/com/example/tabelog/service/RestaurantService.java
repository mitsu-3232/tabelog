 package com.example.tabelog.service;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.tabelog.entity.Restaurant;
import com.example.tabelog.form.RestaurantEditForm;
import com.example.tabelog.form.RestaurantRegisterForm;
import com.example.tabelog.repository.RestaurantRepository;
 
 @Service
 public class RestaurantService {
     private final RestaurantRepository restaurantRepository;    
     
     public RestaurantService(RestaurantRepository restaurantRepository) {
         this.restaurantRepository = restaurantRepository;        
     }    
     
     @Transactional
     public void create(RestaurantRegisterForm restaurantRegisterForm) {
         Restaurant restaurant = new Restaurant();        
         MultipartFile imageFile = restaurantRegisterForm.getImageFile();
         
         if (!imageFile.isEmpty()) {
             String imageName = imageFile.getOriginalFilename(); 
             String hashedImageName = generateNewFileName(imageName);
             Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
             copyImageName(imageFile, filePath);
             restaurant.setImageFile(hashedImageName);
         }
         
         restaurant.setName(restaurantRegisterForm.getName()); 
         restaurant.setCategory(restaurantRegisterForm.getCategory());
         restaurant.setCapacity(restaurantRegisterForm.getCapacity());
         restaurant.setDescription(restaurantRegisterForm.getDescription());
         restaurant.setPriceHigh(restaurantRegisterForm.getPriceHigh());
         restaurant.setPriceLow(restaurantRegisterForm.getPriceLow());
         restaurant.setOpenTime(restaurantRegisterForm.getOpenTime());
         restaurant.setCloseTime(restaurantRegisterForm.getCloseTime());
         restaurant.setPostalCode(restaurantRegisterForm.getPostalCode());
         restaurant.setAddress(restaurantRegisterForm.getAddress());
         restaurant.setPhoneNumber(restaurantRegisterForm.getPhoneNumber());
                     
         restaurantRepository.save(restaurant);
     }  
     
     @Transactional
     public void update(RestaurantEditForm restaurantEditForm) {
         Restaurant restaurant = restaurantRepository.getReferenceById(restaurantEditForm.getId());
         MultipartFile imageFile = restaurantEditForm.getImage_name();
         
         if (!imageFile.isEmpty()) {
             String imageName = imageFile.getOriginalFilename(); 
             String hashedImageName = generateNewFileName(imageName);
             Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
             copyImageName(imageFile, filePath);
             restaurant.setImageFile(hashedImageName);
         }
         
         restaurant.setName(restaurantEditForm.getName()); 
         restaurant.setCategory(restaurantEditForm.getCategory());
         restaurant.setCapacity(restaurantEditForm.getCapacity());
         restaurant.setDescription(restaurantEditForm.getDescription());
         restaurant.setPriceHigh(restaurantEditForm.getPrice_high());
         restaurant.setPriceLow(restaurantEditForm.getPrice_low());
         restaurant.setOpenTime(restaurantEditForm.getOpenTime());
         restaurant.setCloseTime(restaurantEditForm.getCloseTime());
         restaurant.setPostalCode(restaurantEditForm.getPostalCode());
         restaurant.setAddress(restaurantEditForm.getAddress());
         restaurant.setPhoneNumber(restaurantEditForm.getPhoneNumber());
                     
         restaurantRepository.save(restaurant);
     }    
     
  // UUIDを使って生成したファイル名を返す
     public String generateNewFileName(String fileName) {
         String[] fileNames = fileName.split("\\.");                
         for (int i = 0; i < fileNames.length - 1; i++) {
             fileNames[i] = UUID.randomUUID().toString();            
         }
         String hashedFileName = String.join(".", fileNames);
         return hashedFileName;
     }     
     
     // 画像ファイルを指定したファイルにコピーする
     public void copyImageName(MultipartFile imageName, Path filePath) {           
         try {
             Files.copy(imageName.getInputStream(), filePath);
         } catch (IOException e) {
             e.printStackTrace();
         }          
     } 
 }