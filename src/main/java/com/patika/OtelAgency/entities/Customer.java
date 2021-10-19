package com.patika.OtelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer extends User{

    private String phone;

    private int nationalId;

    private String address;
}
