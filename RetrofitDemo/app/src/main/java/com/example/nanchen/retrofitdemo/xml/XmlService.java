package com.example.nanchen.retrofitdemo.xml;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 南尘 on 16-7-18.
 */
public interface XmlService {
    @GET("/portal.php?mod=rss&castid=")
    Call<Channel> getChannel();
}
