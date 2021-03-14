package com.example.cs492final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tagArray = getResources().getStringArray(R.array.tag_array);
        Spinner tagSpinner = findViewById(R.id.tag_spinner);
        ArrayAdapter<String> tagAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, tagArray);
        tagAdapter.setDropDownViewResource(R.layout.spinner_item);
        tagSpinner.setAdapter(tagAdapter);

        String[] difficultyArray = getResources().getStringArray(R.array.difficulty_array);
        Spinner difficultySpinner = findViewById(R.id.difficulty_spinner);
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, difficultyArray);
        difficultyAdapter.setDropDownViewResource(R.layout.spinner_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        String[] letterArray = getResources().getStringArray(R.array.letter_array);
        Spinner letterSpinner = findViewById(R.id.letter_spinner);
        ArrayAdapter<String> letterAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, letterArray);
        difficultyAdapter.setDropDownViewResource(R.layout.spinner_item);
        letterSpinner.setAdapter(letterAdapter);

        String[] partypeArray = getResources().getStringArray(R.array.partype_array);
        Spinner partypeSpinner = findViewById(R.id.partype_spinner);
        ArrayAdapter<String> partypeAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.tv_spinner, partypeArray);
        partypeAdapter.setDropDownViewResource(R.layout.spinner_item);
        partypeSpinner.setAdapter(partypeAdapter);
    }
}