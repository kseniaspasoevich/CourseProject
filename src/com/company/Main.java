package com.company;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Main {
    public static void main(String[] args) {

        //Gson GSON = new Gson();
        TimeTable obj = new TimeTable();
        obj.generateTimeScedule(10);

    }
}
