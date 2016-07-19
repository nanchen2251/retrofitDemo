package com.example.nanchen.retrofitdemo.xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nanchen.retrofitdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class SimpleXmlActivity extends AppCompatActivity implements Callback<Channel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_xml);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.inexus.co")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        XmlService service = retrofit.create(XmlService.class);
        Call<Channel> channel = service.getChannel();
        channel.enqueue(this);

    }

    @Override
    public void onResponse(Call<Channel> call, Response<Channel> response) {
        Channel channel = response.body();
    }

    @Override
    public void onFailure(Call<Channel> call, Throwable t) {
        t.printStackTrace();
    }
}
