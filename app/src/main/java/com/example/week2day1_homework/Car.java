package com.example.week2day1_homework;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    //initializes variables for constructor
    private String year;
    private String make;
    private String model;
    private String color;
    private String engineSize;
    private String tranny;

    //constructor that takes in and assigns all necessary parameters
    public Car(String year, String make, String model, String color, String engineSize, String trans){
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.engineSize = engineSize;
        this.tranny = trans;
    }

    //at the package level, this is for retrieving a car object from a parcel
    protected Car(Parcel in) {
        //retrieving variables from the received parcel
        this.year = in.readString();
        this.make = in.readString();
        this.model = in.readString();
        this.color = in.readString();
        this.engineSize = in.readString();
        this.tranny = in.readString();
    }
    //Creator override
    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    //writes the constructed values to the Parcel object
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(year);
        parcel.writeString(make);
        parcel.writeString(model);
        parcel.writeString(color);
        parcel.writeString(engineSize);
        parcel.writeString(tranny);
    }
}
