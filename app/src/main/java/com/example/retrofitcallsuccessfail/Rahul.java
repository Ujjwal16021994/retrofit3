package com.example.retrofitcallsuccessfail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Rahul {
    @GET("photos")
    Call<List<DataManage>> ptrap();
}
