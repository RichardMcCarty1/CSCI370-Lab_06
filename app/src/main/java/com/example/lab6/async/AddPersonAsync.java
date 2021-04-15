package com.example.lab6.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.lab6.PersonsActivity;
import com.example.lab6.data.LabDatabase;
import com.example.lab6.entities.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddPersonAsync extends AsyncTask<Void, Void, Integer> {
    private LabDatabase database;
    private String name;
    public AddPersonAsync(LabDatabase labDatabase, String name) {
        this.database = labDatabase;
        this.name = name;
    }
    @Override
    protected Integer doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();
        Person newPerson = new Person();
        newPerson.setName(name);
        database.personDao().insertPerson(newPerson);
        return null;
    }
}
