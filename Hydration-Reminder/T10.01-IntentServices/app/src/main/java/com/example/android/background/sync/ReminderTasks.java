package com.example.android.background.sync;

// COMPLETED (1) Create a class called ReminderTasks

import android.content.Context;

import com.example.android.background.utilities.PreferenceUtilities;

public class ReminderTasks {

// COMPLETED (2) Create a public static constant String called ACTION_INCREMENT_WATER_COUNT
    public static final String ACTION_INCREMENT_WATER_COUNT = "incerement-water-count";

// COMPLETED (6) Create a public static void method called executeTask
// COMPLETED (7) Add a Context called context and String parameter called action to the parameter list
// COMPLETED (8) If the action equals ACTION_INCREMENT_WATER_COUNT, call this class's incrementWaterCount
    public static void executeTask(Context context,String action){

        if(action.equals(ACTION_INCREMENT_WATER_COUNT)){
            incrementWaterCount(context);
        }
    }


// COMPLETED (3) Create a private static void method called incrementWaterCount
// COMPLETED (4) Add a Context called context to the argument list
    private static void incrementWaterCount(Context context){
        // COMPLETED (5) From incrementWaterCount, call the PreferenceUtility method that will ultimately update the water count
        PreferenceUtilities.incrementWaterCount(context);

    }


}
