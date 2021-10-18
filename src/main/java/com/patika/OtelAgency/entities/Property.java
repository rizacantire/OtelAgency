package com.patika.OtelAgency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "property")
public class Property  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String property;

    @ManyToMany
    //@JoinColumn(name = "otel_id")
    @JsonIgnore
    private List<Otel> otels;

}
