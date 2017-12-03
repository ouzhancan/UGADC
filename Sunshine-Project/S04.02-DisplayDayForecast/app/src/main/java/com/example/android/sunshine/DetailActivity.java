package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String mForecast;
    private TextView mWeatherDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDetailText =  (TextView) findViewById(R.id.tv_weather_detail_data);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        Intent intent = getIntent();

        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            mForecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            mWeatherDetailText.setText(mForecast);
        }
    }
}