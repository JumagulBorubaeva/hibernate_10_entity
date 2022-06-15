package com.peaksoft.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="cows")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public Cow(String name, int age) {
        this.name = name;
        this.age = age;

    }

}
