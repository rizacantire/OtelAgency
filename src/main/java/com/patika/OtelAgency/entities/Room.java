package com.patika.OtelAgency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numberOfBed;

    private boolean tv;

    private boolean minibar;

    private boolean gameConsole;

    private int area;

    private boolean projection;

    private boolean safeCase;

    private int numberOfRoom;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToMany
    @JoinColumn(name = "otel_id")
    @JsonIgnore
    private List<Otel> otels;

}
