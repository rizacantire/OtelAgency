package com.patika.OtelAgency.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patika.OtelAgency.dataAccess.abstracts.OtelDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "otel")
public class Otel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;
    private String mail;
    private String phone;
    private int star;

    @ManyToOne
    @JoinColumn(name = "otel_type_id")
    private OtelType otelType;

    @ManyToMany
    @JoinColumn(name = "property_id")
    private Set<Property> otelProperties;
}
