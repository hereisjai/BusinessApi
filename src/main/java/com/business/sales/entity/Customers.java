package com.business.sales.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    private long phone; 
    private String name;
    private String email;
    private String doorNo;
    private String city;
    private String street;
    private String village;
    private long totalQty;
    private String latitude;
    private String longitude;
    private boolean morningBuyer; // Indicates if the customer buys products in the morning
    private boolean eveningBuyer; // Indicates if the customer buys products in the evening
}