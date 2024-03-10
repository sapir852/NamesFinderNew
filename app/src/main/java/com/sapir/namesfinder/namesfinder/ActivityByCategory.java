package com.sapir.namesfinder.namesfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sapir.namegenerator.NameController;
import com.sapir.namesfinder.R;

public class ActivityByCategory extends AppCompatActivity {
    private Button BycategoryButtonBack,searchButton;
    private TextView BycategoryLBL ;
    private Spinner letterSpinner;
    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_category);
        findViews();
        initViews();
        CategorySpinnerAdapter adapter = new CategorySpinnerAdapter(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterSpinner.setAdapter(adapter);
    }


    private void findViews() {
        BycategoryButtonBack =findViewById(R.id.BycategoryButtonBack);
        BycategoryLBL =findViewById(R.id.BycategoryLBL);
        letterSpinner = findViewById(R.id.letterSpinner);
        searchButton= findViewById(R.id.searchButton);


    }

    private void initViews() {
        BycategoryButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        letterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Save the selected category to the global variable
                selectedCategory = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        NameController nameController = new NameController(new MyCallback());
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if a category is selected
                if (selectedCategory != null) {
                    // Use the selected category to fetch names
                    nameController.fetchByCategory(selectedCategory);
                } else {
                    // Handle case where no category is selected
                    Toast.makeText(ActivityByCategory.this, "Please select a category", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}