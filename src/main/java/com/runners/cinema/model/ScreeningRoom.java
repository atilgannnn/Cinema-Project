package com.runners.cinema.model;

import com.runners.cinema.model.enums.ScreenTypeEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_screeningroom")
public class ScreeningRoom{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,nullable = false)
    private String name;

    private Set<Seats> seat;
    @Column(nullable = false)
    private boolean isOccupied;

    private Set<Movie> movie=new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Set<ScreenTypeEnum> screenTypeEnum;

    public ScreeningRoom() {
    }

    public ScreeningRoom(long id, String name, boolean isOccupied, Set<ScreenTypeEnum> screenTypeEnum) {
        this.id = id;
        this.name = name;
        this.isOccupied = isOccupied;
        this.screenTypeEnum=screenTypeEnum;
    }

    public long getId() {
        return id;
    }

//        public void setId(long id) {
//            this.id = id;
//        }


    public Set<ScreenTypeEnum> getScreenTypeEnum() {
        return screenTypeEnum;
    }

    public void setScreenTypeEnum(Set<ScreenTypeEnum> screenTypeEnum) {
        this.screenTypeEnum = screenTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}