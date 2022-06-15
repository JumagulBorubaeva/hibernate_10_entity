package com.peaksoft.entity3;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="docs")
@Setter
@Getter
@ToString
@NoArgsConstructor

public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public Doc(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
