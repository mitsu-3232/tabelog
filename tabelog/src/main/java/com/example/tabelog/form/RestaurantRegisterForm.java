package com.example.tabelog.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantRegisterForm {
    @NotBlank(message = "店舗名を入力してください。")
    private String name;
    
    @NotBlank(message = "カテゴリを選択してください。")
    private String category;
        
    private MultipartFile imageFile; 

    @NotBlank(message = "説明を入力してください。")
    private String description;   
    
    @NotNull(message = "上限金額を入力してください。")
    @Min(value = 1, message = "宿泊料金は1円以上に設定してください。")
    private Integer priceHigh; 
    
    @NotNull(message = "下限金額を選択してください。")
    @Min(value = 1, message = "宿泊料金は1円以上に設定してください。")
    private Integer priceLow; 
    
    @NotNull(message = "予約可能人数を入力してください。")
    @Min(value = 1, message = "定員は1人以上に設定してください。")
    private Integer capacity;   
    
    @NotNull(message = "営業開始時間を入力してください。")
    private LocalTime openTime;
    
    @NotNull(message = "営業終了時間を入力してください。")
    private LocalTime closeTime; 
    
    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;
    
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;
}
