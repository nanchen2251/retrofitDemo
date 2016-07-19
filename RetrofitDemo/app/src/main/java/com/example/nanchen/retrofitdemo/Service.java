package com.example.nanchen.retrofitdemo;

import com.example.nanchen.retrofitdemo.json.Tngou;
import com.example.nanchen.retrofitdemo.xml.Channel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 南尘 on 16-7-15.
 */
public interface Service {
    @GET("/")//网址下面的子目录
    Call<String> getBaidu();

    @GET("/api/{category}/list")//网址下面的子目录   category表示分类，因为子目录只有一点不一样
    Call<Tngou> getList(@Path("category") String path,@Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    @POST("/api/{category}/list")//使用Post实现
    @FormUrlEncoded  //使用Field属性必须添加这个
    Call<Tngou> getListForPost(@Path("category") String path, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);


}
