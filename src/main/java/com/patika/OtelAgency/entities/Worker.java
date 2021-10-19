package com.patika.OtelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "worker")
public class Worker extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;


}
