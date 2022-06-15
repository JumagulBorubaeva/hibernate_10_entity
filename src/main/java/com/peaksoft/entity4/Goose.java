package com.peaksoft.entity4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name="gooses")
@NoArgsConstructor

public class Goose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
     private int age ;

    public Goose(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

