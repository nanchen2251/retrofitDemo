package com.example.nanchen.retrofitdemo.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.nanchen.retrofitdemo.R;
import com.example.nanchen.retrofitdemo.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitJsonActivity extends AppCompatActivity implements Callback<Tngou> {


    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_json);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        Call<Tngou> call = service.getList("cook",0, 1, 100);
        call.enqueue(this);
        lv = (ListView) findViewById(R.id.json_lv);

    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<Cook> list = response.body().getList();
        lv.setAdapter(new MyAdapter(this,list));
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {

    }
}
