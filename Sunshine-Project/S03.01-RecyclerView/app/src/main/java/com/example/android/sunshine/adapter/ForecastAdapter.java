package com.example.android.sunshine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.MainActivity;
import com.example.android.sunshine.R;

import java.util.List;

/**
 * Created by ouz on 03/12/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private List<String> mWeatherData;

    private Context context;

    public ForecastAdapter() {
    }

    public void setmWeatherData(String weatherData){
        this.mWeatherData.add(weatherData);

        notifyDataSetChanged();
    }


    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        boolean attachToRoot = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.forecast_list_item,parent,attachToRoot);

        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherForThisDay = mWeatherData.get(position);
        holder.mWeatherTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData.size()<=0 || mWeatherData.isEmpty() || mWeatherData == null){
            return 0;
        }else{
            return mWeatherData.size();
        }
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);

            mWeatherTextView = (TextView)view.findViewById(R.id.tv_weather_data);

        }
    }
}
