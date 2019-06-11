package com.example.week2day1_homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //initializes textView
    TextView textView;
    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets view to main
        setContentView(R.layout.activity_main);
        //sets text view to textDisplay from its XML
        textView = findViewById(R.id.textDisplay);
    }

    //onClick
    public void onClick(View v) {
        //for whichever button is clicked
        switch(v.getId()){
            //because there is only one button, technically this doesn't need to be switch, but low on time so not deleting
            case R.id.btnAction:
                //startsActivityForCarResult()
                startActivityForResult();
                break;
        }

    }


    private void startActivityForResult() {
        //new intent from current activity to Registration entry class
        Intent startActForCarResultIntent =
                new Intent(this, RegistrationDataEntry.class);
        //starts the built in ActivityForResult function with the newly created intent and its request code
        startActivityForResult(startActForCarResultIntent, 112);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if the request code is correct and the data is not an empty container
        if (requestCode==112 && data!=null) {
            //sets a bundle to retrieve the passed bundle
            Bundle carBundle = data.getExtras();
            //if not null
            if (carBundle!=null){
                //looks for object with key "car"
                Car newCar = carBundle.getParcelable("car");
                //checks for null object
                if (newCar!=null){
                    //if object newCar is not null, sets the textView to visible
                    textView.setVisibility(View.VISIBLE);
                    //begins the text view with "saved car: "
                    textView.setText("Saved Car: \"n");
                    //appends the the car object that was retrieved to the view
                    textView.append(newCar.toString());
                }
            }
        }

    }

}