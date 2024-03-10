package com.sapir.namesfinder.namesfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sapir.namegenerator.NameController;
import com.sapir.namesfinder.R;

import org.w3c.dom.Text;

import java.util.List;

public class ActivityAllNames extends AppCompatActivity {
    private Button allNamesButtonBack;
    private TextView allNamesLBL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_names);
        findViews();
        initViews();
        MyCallback myCallback = new MyCallback(); // Pass reference to this activity

        // Create an instance of NameController
        NameController nameController = new NameController(myCallback);

        // Call the fetchAllName method to fetch all names
        nameController.fetchAllName();


    }
    public void updateNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name).append("\n");
        }
        allNamesLBL.setText(stringBuilder.toString());
    }


    private void findViews() {
        allNamesButtonBack =findViewById(R.id.allNamesButtonBack);
        allNamesLBL =findViewById(R.id.allNamesLBL);


    }

    private void initViews() {
        allNamesButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}