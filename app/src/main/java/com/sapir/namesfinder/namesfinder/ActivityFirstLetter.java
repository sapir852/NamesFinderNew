package com.sapir.namesfinder.namesfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.sapir.namegenerator.NameController;
import com.sapir.namesfinder.R;

public class ActivityFirstLetter extends AppCompatActivity {
    private String selectedLetter;
    Spinner  letterSpinner;
    Button searchButton,ByFirstLetterButtonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_letter);
        findViews();
        initViews();

        LetterSpinnerAdapter adapter = new LetterSpinnerAdapter(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterSpinner.setAdapter(adapter);

        // Set the OnItemSelectedListener
        letterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Save the selected letter to the global variable
                selectedLetter = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        MyCallback myCallback = new MyCallback();

        // Create an instance of NameController
        NameController nameController = new NameController(myCallback);

        // Now you can use the selectedLetter wherever needed
        // For example, if you want to fetch names when a button is clicked
         searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if a letter is selected
                if (selectedLetter != null) {
                    // Use the selected letter to fetch names
                    nameController.fetchByLetter(selectedLetter);

                } else {
                    // Handle case where no letter is selected
                    Toast.makeText(ActivityFirstLetter.this, "Please select a letter", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void findViews() {
        ByFirstLetterButtonBack=findViewById(R.id.ByFirstLetterButtonBack);
        letterSpinner = findViewById(R.id.letterSpinner);


    }
    private void initViews() {
        ByFirstLetterButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
    }
