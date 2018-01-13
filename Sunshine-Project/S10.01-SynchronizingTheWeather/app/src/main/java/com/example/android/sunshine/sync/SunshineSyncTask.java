package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  COMPLETED (1) Create a class called SunshineSyncTask
public class SunshineSyncTask{

    //  COMPLETED (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    /**
          * Performs the network request for updated weather, parses the JSON from that request, and
          * inserts the new weather information into our ContentProvider. Will notify the user that new
          * weather has been loaded if the user hasn't been notified of the weather within the last day
          * AND they haven't disabled notifications in the preferences screen.
          *
          * @param context Used to access utility methods and the ContentResolver
          */
    synchronized public static void syncWeather(Context context){
//      COMPLETED (3) Within syncWeather, fetch new weather data

        try{

           /*
+             * The getUrl method will return the URL that we need to get the forecast JSON for the
+             * weather. It will decide whether to create a URL based off of the latitude and
+             * longitude or off of a simple location as a String.
+             */
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            /* Use the URL to retrieve the JSON */
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context,jsonWeatherResponse);

            if(weatherValues != null && weatherValues.length != 0 ){
                ContentResolver sunshineContentResolver = context.getContentResolver();

                // delete old
                sunshineContentResolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,null
                );

                //      COMPLETED (4) If we have valid results, delete the old data and insert the new
                // insert new
                sunshineContentResolver.bulkInsert(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherValues
                );
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }





    }

}