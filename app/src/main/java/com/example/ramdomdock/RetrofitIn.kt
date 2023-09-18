package com.example.ramdomdock

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitIn {
    //base="https://random-d.uk/api/random"

    @GET("random")
    fun getImages(): Call<model_class>

}





