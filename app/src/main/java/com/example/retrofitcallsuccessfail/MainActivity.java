package com.example.retrofitcallsuccessfail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView userId,Id,title,completed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = findViewById(R.id.iduserId);
        Id = findViewById(R.id.idId);
        title = findViewById(R.id.idtitle);
        completed = findViewById(R.id.idcompleted);

        String url = "https://jsonplaceholder.typicode.com/todos/1/";
//                    https://jsonplaceholder.typicode.com/todos/1/photos
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Rahul nalue = retrofit.create(Rahul.class);
        Call<List<DataManage>> nato = nalue.ptrap();
        nato.enqueue(new Callback<List<DataManage>>() {
            @Override
            public void onResponse(Call<List<DataManage>> call, Response<List<DataManage>> response) {
                Log.e("tag","~~~~~~~~~~~~~response~~~~~~~~~~~~"+response.body());
                Toast.makeText(MainActivity.this,"on success!!",Toast.LENGTH_SHORT).show();







            }

            @Override
            public void onFailure(Call<List<DataManage>> call, Throwable t) {
                Log.e("tag","~~~~~~~~~~~~~~~~~Failuer~~~~~~~~~~~~~~~~~~~"+t.getLocalizedMessage());
                Toast.makeText(MainActivity.this,"Failed to run api, Please try again",Toast.LENGTH_LONG).show();
            }
        });

    }
}