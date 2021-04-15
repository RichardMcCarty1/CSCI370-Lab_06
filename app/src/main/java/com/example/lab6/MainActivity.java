package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab6.async.AddPersonAsync;
import com.example.lab6.async.GetAllPersonsAsync;
import com.example.lab6.data.LabDatabase;

public class MainActivity extends AppCompatActivity {
    private Button submitBut;
    private Button listBut;
    private EditText inputText;
    private LabDatabase labDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBut = findViewById(R.id.submitBut);
        listBut = findViewById(R.id.listBut);
        inputText = findViewById(R.id.editTextTextPersonName);
        labDB = Room.databaseBuilder(this, LabDatabase.class, "personDB")
                .build();
        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), inputText.getText().toString(), Toast.LENGTH_LONG).show();
                new AddPersonAsync(labDB, inputText.getText().toString()).execute();
            }
        });
        listBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetAllPersonsAsync(labDB, getApplicationContext()).execute();
            }
        });


    }
}