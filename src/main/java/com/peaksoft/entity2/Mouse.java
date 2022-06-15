package com.peaksoft.entity2;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString

@Table(name="mouses")
@NoArgsConstructor

public class Mouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private int age;


    public Mouse(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


