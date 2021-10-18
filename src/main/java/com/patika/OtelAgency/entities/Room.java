package com.patika.OtelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "room_type_id")

    private RoomType roomType;

}
