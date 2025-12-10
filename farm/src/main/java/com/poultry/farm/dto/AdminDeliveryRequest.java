package com.poultry.farm.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminDeliveryRequest {
    private String vehicleNumber;
    private String driverName;
    private String driverPhone;
    private LocalDateTime actualDeliveryTime;

}
