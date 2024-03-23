package com.fourinone.finalproject.block2.upanghub

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitbuilder {

    private const val BASE_URL = "http://10.40.70.87/api/"

    // Function to build the service instance using the stored authentication token
    fun <T> buildService(serviceType: Class<T>): T {
        val httpClient = OkHttpClient.Builder()

        // Add interceptor for adding authentication token to each request if token is provided

//        val gson = GsonBuilder().setLenient().create() // Create Gson with lenient parsing
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return retrofit.create(serviceType)
    }
}