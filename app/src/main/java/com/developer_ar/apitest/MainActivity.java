package com.developer_ar.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton button1, button2, button3, button4;
    private ApiInterface apiInterface;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        button1 = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.button1);
        button2 = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.button2);
        button3 = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.button3);
        button4 = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<HttpResult>> call = apiInterface.getTodos();
                call.enqueue(new Callback<List<HttpResult>>() {
                    @Override
                    public void onResponse(Call<List<HttpResult>> call, Response<List<HttpResult>> response) {
                        Log.e(TAG, "Getting Response: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<List<HttpResult>> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                    }
                });
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<HttpResult> call = apiInterface.getTodo(2);
                call.enqueue(new Callback<HttpResult>() {
                    @Override
                    public void onResponse(Call<HttpResult> call, Response<HttpResult> response) {
                        Log.e(TAG, "Getting Response: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<HttpResult> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                    }
                });
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<HttpResult>> call = apiInterface.getTodoUsingQuery(1, true);
                call.enqueue(new Callback<List<HttpResult>>() {
                    @Override
                    public void onResponse(Call<List<HttpResult>> call, Response<List<HttpResult>> response) {
                        Log.e(TAG, "Getting Response: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<List<HttpResult>> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                    }
                });
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpResult data = new HttpResult(4, "Testing my Api requests", false);

                Call<HttpResult> postTodo = apiInterface.postTodo(data);
                postTodo.enqueue(new Callback<HttpResult>() {
                    @Override
                    public void onResponse(Call<HttpResult> call, Response<HttpResult> response) {
                        Log.e(TAG, "Getting Response: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<HttpResult> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                    }
                });
            }
        });
    }
}