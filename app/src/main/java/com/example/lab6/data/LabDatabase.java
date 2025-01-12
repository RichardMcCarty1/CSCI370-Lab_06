package com.example.lab6.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lab6.entities.Person;
import com.example.lab6.dao.PersonDao;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
