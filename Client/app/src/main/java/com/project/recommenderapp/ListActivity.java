package com.project.recommenderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.project.recommenderapp.retrofit.IUploadAPI;
import com.project.recommenderapp.retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    IUploadAPI mService;
    ListView list;
    private IUploadAPI getAPIUpload(){
        return RetrofitClient.getClient().create(IUploadAPI.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mService=getAPIUpload();
        list=findViewById(R.id.list);

        Intent intent = this.getIntent();
                mService.getAllRecords(intent.getStringExtra("location"),
                        intent.getStringExtra("rating"),
                        intent.getStringExtra("cost"),
                        intent.getStringExtra("cuisine")).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String r1=response.body();
                        String res[]=response.body().split("\n");
                        ArrayList<Restaurant> al=new ArrayList<>();
                        for(int i=0;i<res.length;i+=6)
                        {
                            Restaurant r=new Restaurant(res[i+0],res[i+1],res[i+2],res[i+3],res[i+4],res[i+5]);
                            al.add(r);
                        }
                        ListAdapterRestaurant listAdapter = new ListAdapterRestaurant(ListActivity.this,al);
                        list.setAdapter(listAdapter);
                        list.setClickable(true);
                        list.setOnItemClickListener((parent, view, position, id) -> {
                            Intent viewIntent =
                                    new Intent("android.intent.action.VIEW",
                                            Uri.parse(al.get(position).getUrl()));
                            startActivity(viewIntent);
                        });
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            }
    }
