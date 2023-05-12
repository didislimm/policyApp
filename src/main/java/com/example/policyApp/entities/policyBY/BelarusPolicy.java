package com.example.policyApp.entities.policyBY;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BelarusPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private int termOfInsurance;

    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    private Date startInsurance;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endInsurance;

    private String type;
    private String brand;
    private String registrationNumber;
    private int engineCapacity;
    private double loadCapacity;
    private int numberOfPlaces;
    private int power;
    private String WinNumber;
    private double insuranceFeeInEuro;
    private double insuranceFeeInByn;
    private String rate;
    private double k1;
    private double k2;
    private double k3;
    private double discount;
    private double total;
    private String paymentMethod;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agreementDate;

    private double secondPartInsuranceFee;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfSecondFee;

    private String ownerFullName;
    private String policyHolderFullName;
    private boolean isActive;
    private double totalWithDiscount;
    private boolean isPaid;

}
