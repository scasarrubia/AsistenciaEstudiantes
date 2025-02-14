package com.example.asistenciaestudiante.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://script.google.com/macros/s/AKfycbx-fKAntSvGAYce3Gm11WvgKCH5cP4Ctwg0i-Rs6ArpMwoSYZC94UZg3FCWyeUi-l2CbA/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
