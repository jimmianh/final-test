package com.fpt.fresher.java.demo.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private LocalDate birthday;
    private String address;
    private  String identityNo;
    private String customerType;
    private int status;
    private LocalDateTime createDatetime;
    private LocalDateTime updatDateTime;
}
