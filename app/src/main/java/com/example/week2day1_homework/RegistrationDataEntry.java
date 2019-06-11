package com.example.week2day1_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import static com.example.week2day1_homework.R.layout.activity_registration_data_entry;

public class RegistrationDataEntry extends AppCompatActivity {
    //initializes the intent and all editTexts
    Intent carIntent;
    EditText carYear;
    EditText carMake;
    EditText carModel;
    EditText carColor;
    EditText engineSize;
    EditText transmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the view to be what the
        setContentView(activity_registration_data_entry);
        //assigning vars to respective view objs
        carYear=findViewById(R.id.etYear);
        carMake=findViewById(R.id.etMake);
        carModel=findViewById(R.id.etModel);
        carColor=findViewById(R.id.etColor);
        engineSize=findViewById(R.id.etEngineSize);
        transmission=findViewById(R.id.etTransmission);
        //gets the intent
        carIntent = getIntent();

    }

    public void onClick(View view) {
        //sets all String variables to what the user enters
        String year = carYear.getText().toString();
        String make = carMake.getText().toString();
        String model = carModel.getText().toString();
        String color = carColor.getText().toString();
        String engine = engineSize.getText().toString();
        String tran = transmission.getText().toString();
        //creates new car object with all necessary params
        Car passedCar = new Car(year, make, model, color, engine, tran);
        //creates new bundle
        Bundle carBundle = new Bundle();
        //parcels the car bundle with "car" as the key and passes the car object
        carBundle.putParcelable("car", passedCar);
        //sets new intent which goes from this class to the main
        carIntent = new Intent(this, MainActivity.class);
        //sends the bundle with with the intent
        carIntent.putExtras(carBundle);
        //sets destination in action with code via intent
        setResult(112, carIntent);
        finish();
    }

    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }*/
}
