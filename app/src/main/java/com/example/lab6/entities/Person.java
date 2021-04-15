package com.example.lab6.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;

    private String name;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setName(String newName) {
        name = newName;
    }
}
