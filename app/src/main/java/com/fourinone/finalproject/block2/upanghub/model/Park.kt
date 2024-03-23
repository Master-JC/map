package com.fourinone.finalproject.block2.upanghub.model

import com.google.gson.annotations.SerializedName

data class Park(
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    val status: String
)
