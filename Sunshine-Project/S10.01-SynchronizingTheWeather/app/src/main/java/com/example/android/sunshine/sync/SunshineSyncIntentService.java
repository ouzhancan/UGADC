package com.example.android.sunshine.sync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

// COMPLETED (5) Create a new class called SunshineSyncIntentService that extends IntentService
public class SunshineSyncIntentService extends IntentService{

    public SunshineSyncIntentService(){
        super("name");
    }

    //  COMPLETED (6) Create a constructor that calls super and passes the name of this class
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SunshineSyncIntentService(String name) {
        super("SunshineSyncIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
//  COMPLETED (7) Override onHandleIntent, and within it, call SunshineSyncTask.syncWeather
        SunshineSyncTask.syncWeather(this);
    }
}

