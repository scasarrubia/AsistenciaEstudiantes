package com.example.asistenciaestudiante.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://script.google.com/macros/s/AKfycbwmtyRd7TkCOOHhNn8zJlHfox77CCVPVbqQd626VEO1dTsLT45DhyVlwZ7Tfn_P7G49fA/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
