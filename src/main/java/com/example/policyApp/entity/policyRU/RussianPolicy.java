package com.example.policyApp.entity.policyRU;
// TODO 1 владелец машины
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
public class RussianPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int termOfInsurance;
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm")
    private Date startInsurance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endInsurance;

    private String policyHolder;


    private boolean isTrailer;
    private String brand;
    private String WinNumber;
    private String registrationNumber;

    private String typeOfDocument;
    private String series;
    private String numberOfDocument;

    private String ownerFullName;
    private String drivingLicenseSeries;
    private String drivingLicenseNumber;

    private Double insurancePremium;
    @Column(columnDefinition = "text")
    private String specialMarks;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agreementDate;
}
