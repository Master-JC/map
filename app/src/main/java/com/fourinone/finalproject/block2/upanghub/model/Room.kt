package com.fourinone.finalproject.block2.upanghub.model

import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("id")
    val id :Int,
    @SerializedName("room_code")
    val room_code: String,
    @SerializedName("img")
    val img: String
)
