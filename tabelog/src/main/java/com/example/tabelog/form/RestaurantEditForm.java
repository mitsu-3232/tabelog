package com.example.tabelog.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RestaurantEditForm {
    @NotNull
    private Integer id;    
    
    @NotBlank(message = "店舗名を入力してください。")
    private String name;
   
    @NotBlank(message = "カテゴリを選択してください。")
    private String category;
    
    private MultipartFile imageFile;
    
    @NotBlank(message = "説明を入力してください。")
    private String description; 
    
    @NotNull(message = "上限金額を選択してください。")
    @Min(value = 1, message = "料金は1円以上に設定してください。")
    private Integer price_high;
    
    @NotNull(message = "下限金額を選択してください。")
    @Min(value = 1, message = "料金は1円以上に設定してください。")
    private Integer price_low;
    
    @NotNull(message = "定員を入力してください。")
    @Min(value = 1, message = "定員は1人以上に設定してください。")
    private Integer capacity;  
    
    //休業日を設定させるかはまだ未確定。    
    @NotNull(message = "休業日を入力してください。")
    private Integer business_day;   
    
    @NotNull(message = "営業開始時間を入力してください。")
    private Integer open;
    
    @NotNull(message = "営業終了時間を入力してください。")
    private Integer close; 
    
    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;
    
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;
}

