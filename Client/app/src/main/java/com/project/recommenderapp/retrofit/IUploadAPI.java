package com.project.recommenderapp.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface IUploadAPI {

    @GET("/api/recommend")
    Call<String> getAllRecords(@Query("location") String location,
                               @Query("rating") String rating,
                               @Query("cost") String cost,
                               @Query("cuisine") String cuisine);

}





