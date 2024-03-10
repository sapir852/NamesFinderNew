package com.sapir.namesfinder.namesfinder;

import android.util.Log;
import android.widget.TextView;

import com.sapir.namegenerator.Name;
import com.sapir.namegenerator.NameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCallback implements NameController.CallBack_Name {


    @Override
    public void successNames(List<Name> names) {
       //  List<String> nameContents = new ArrayList<>();
        // Handle successful retrieval of a list of Name objects
        System.out.println("Success! Names: ");
        for (Name name : names) {
           // nameContents.add(name.getContent());
            Log.d("ssts",""+name.getContent());
             System.out.println(name.getContent());
        }


    }

    @Override
    public void errorNames(String error) {
        // Handle error when fetching a list of Name objects
        System.err.println("Error fetching names: " + error);
    }
     public void fillterByLetter (String letterFilter, List<Name> names){

        for (Name name:names){

            if (name.getFirstChar().equalsIgnoreCase(letterFilter)){
                Log.d("ssts",""+name.getContent());
                System.out.println(name.getContent());
            }
        }
     }

    public void fillterByCategory (String categoryFillter, List<Name> names){
        for (Name name:names){
            if (name.getCategory().equalsIgnoreCase(categoryFillter)){
                Log.d("ssts",""+name.getContent());
                System.out.println(name.getContent());
            }
        }
    }

    public void fillterByCategoryAndLetter (String categoryFillter,String letterFilter, List<Name> names){

        for (Name name:names){
            if (name.getCategory().equalsIgnoreCase(categoryFillter)&&name.getFirstChar().equalsIgnoreCase(letterFilter)){
                Log.d("ssts",""+name.getContent());

            }


        }
    }

    public void Randomfillter ( List<Name> names){

        Random random = new Random();
        int randomNumber = random.nextInt(102) + 1; // Generates random number between 0 (inclusive) and 102 (exclusive)

                Log.d("ssts",""+names.get(randomNumber).getContent());
                System.out.println(names.get(randomNumber).getContent());



    }
}