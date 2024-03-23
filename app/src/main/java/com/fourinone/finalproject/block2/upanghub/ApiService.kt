package com.fourinone.finalproject.block2.upanghub

import com.fourinone.finalproject.block2.upanghub.model.Room
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("room")
    fun getRoomsList(): Call<List<Room>>

    @GET("room/{id}")
    fun getRoom(@Path("id") id : Int) : Call<Room>

}