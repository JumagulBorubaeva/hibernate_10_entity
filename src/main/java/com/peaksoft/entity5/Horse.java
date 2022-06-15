package com.peaksoft.entity5;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="horses")

public class Horse {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    public Horse(String name, int age) {
        this.name = name;
        this.age = age;
    }
}