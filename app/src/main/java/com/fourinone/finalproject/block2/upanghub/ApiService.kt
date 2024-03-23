package com.fourinone.finalproject.block2.upanghub

import com.fourinone.finalproject.block2.upanghub.model.Park
import com.fourinone.finalproject.block2.upanghub.model.Room
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {


    @GET("room")
    fun getRoomsList(): Call<List<Room>>

    @GET("room/{id}")
    fun getRoom(@Path("id") id : Int) : Call<Room>

    @GET("parking")
    fun getParkList(): Call<List<Park>>

    @GET("parking/{id}")
    fun showParking(@Path("id") id :Int): Call<Park>


    @PUT("parking/{id}/available")
    fun available(@Path("id") id: Int) : Call<Unit>
    @PUT("parking/{id}/occupied")
    fun occupied(@Path("id") id: Int) : Call<Unit>

}