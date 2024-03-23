package com.fourinone.finalproject.block2.upanghub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fourinone.finalproject.block2.upanghub.databinding.ActivityParkingBinding
import com.fourinone.finalproject.block2.upanghub.databinding.ActivityRoomViewBinding
import com.fourinone.finalproject.block2.upanghub.model.Park
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParkingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParkingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getParkList()

    }

    private fun getParkList() {
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.getParkList()

        call.enqueue(object : Callback<List<Park>> {
            override fun onResponse(call: Call<List<Park>>, response: Response<List<Park>>) {
                if (response.isSuccessful) {
                    val parkList = response.body() // List of Park objects
                    parkList?.forEach { park ->
                        val status = park.status // Access status property of each Park object
                        val id = park.id
                        // Do something with the status
                        binding.apply {
                        when(id) {
                            1 -> {
                                when (status) {
                                    "available" -> {
                                        btnP1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            2 -> {
                                when (status) {
                                    "available" -> {
                                        btnP2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            3 -> {
                                when (status) {
                                    "available" -> {
                                        btnP3.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP3.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            4 -> {
                                when (status) {
                                    "available" -> {
                                        btnP4.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP4.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            5 -> {
                                when (status) {
                                    "available" -> {
                                        btnP5.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP5.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            6 -> {
                                when (status) {
                                    "available" -> {
                                        btnP6.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP6.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            7 -> {
                                when (status) {
                                    "available" -> {
                                        btnP7.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP7.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            8 -> {
                                when (status) {
                                    "available" -> {
                                        btnP8.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP8.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            9 -> {
                                when (status) {
                                    "available" -> {
                                        btnP9.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP9.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                            10 -> {
                                when (status) {
                                    "available" -> {
                                        btnP10.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green))
                                    }
                                    "occupied" ->{
                                        btnP10.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.red))
                                    }
                                }
                            }
                        }


                    }
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<List<Park>>, t: Throwable) {
                // Handle failure
            }
        })
    }



}