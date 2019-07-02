package com.example.week4test.model.datasource.remote;

import com.example.week4test.model.datasource.coffee.CoffeeResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class CoffeeRetroFit {
    public static final String BASE_URL = "https://demo6983184.mockable.io/coffees/";

    private Retrofit getRetrofitInstance(){
        return  new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    private GetCoffeeService getCoffeeService(){
        return getRetrofitInstance().create(GetCoffeeService.class);
    }

    public Call<CoffeeResponse> getCoffeeResponses(String string){
        return getCoffeeService().getCoffeeResponse(string);
    }

    public interface  GetCoffeeService {
        @GET
        Call<CoffeeResponse> getCoffeeResponse(@Url String url);

    }
}
