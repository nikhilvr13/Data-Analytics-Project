package com.project.recommenderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapterRestaurant extends ArrayAdapter<Restaurant> {


    public ListAdapterRestaurant(Context context, ArrayList<Restaurant> restaurantArrayList){
        super(context, R.layout.list_item,restaurantArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Restaurant restaurant = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView restaurantName = convertView.findViewById(R.id.listname);
        TextView restaurantCuisines = convertView.findViewById(R.id.listcuisine);
        TextView restaurantrate = convertView.findViewById(R.id.listRate);
        TextView restauranttype = convertView.findViewById(R.id.listresttype);
        TextView restaurantcost = convertView.findViewById(R.id.listcost);

        restaurantName.setText(restaurant.getName());
        restaurantCuisines.setText(restaurant.getCuisines());
        restaurantrate.setText("Rating : "+restaurant.getRate());
        restauranttype.setText(restaurant.getType());
        restaurantcost.setText("Rs."+restaurant.getCost()+" for two");
        return convertView;
    }
}