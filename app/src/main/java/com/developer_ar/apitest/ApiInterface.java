package com.developer_ar.apitest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/todos")
    Call<List<HttpResult>> getTodos();

    @GET("todos/{id}")
    Call<HttpResult> getTodo(@Path("id") int id);

    @GET("/todos")
    Call<List<HttpResult>> getTodoUsingQuery(@Query("userId") int userId, @Query("completed") boolean completed);

    @POST("/todos")
    Call<HttpResult> postTodo(@Body HttpResult data);
}
