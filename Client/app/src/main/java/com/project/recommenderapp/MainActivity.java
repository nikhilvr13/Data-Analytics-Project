package com.project.recommenderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText cost;
    EditText rating;
    EditText location;
    EditText cuisine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.submit);
        cost=findViewById(R.id.cost);
        rating=findViewById(R.id.rating);
        location=findViewById(R.id.location);
        cuisine=findViewById(R.id.cuisine);

        b.setOnClickListener(view -> {
            Intent i=new Intent(getApplicationContext(), ListActivity.class);
            i.putExtra("cost",cost.getText().toString());
            i.putExtra("rating",rating.getText().toString());
            i.putExtra("location",location.getText().toString());
            i.putExtra("cuisine",cuisine.getText().toString());
            startActivity(i);
        });

    }
}