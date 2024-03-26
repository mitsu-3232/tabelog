package com.example.tabelog.form;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
    @NotNull(message = "予約人数を入力してください。")
    @Min(value = 1, message = "予約人数は1人以上に設定してください。")
    private Integer numberOfPeople;

    @NotNull(message = "予約日を入力してください。")
    private String reservedDate;

    @NotNull(message = "予約時刻を入力してください。")
    private String reservedTime;

    
    // 予約日を取得する
    public LocalDate getReservedDate() {
        return LocalDate.parse(reservedDate);
    }

    // 予約時間を取得する
    public LocalTime getReservedTijme() {
        return LocalTime.parse(reservedTime);
    }

    
    /* チェックイン日を取得する
    public LocalDate getCheckinDate() {
        String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split(" から ");
        return LocalDate.parse(checkinDateAndCheckoutDate[0]);
    }

    // チェックアウト日を取得する
    public LocalDate getCheckoutDate() {
        String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split(" から ");
        return LocalDate.parse(checkinDateAndCheckoutDate[1]);
    }
     */
}
