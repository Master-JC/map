package com.fourinone.finalproject.block2.upanghub

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.fourinone.finalproject.block2.upanghub.databinding.ActivitySecurityParkBinding
import com.fourinone.finalproject.block2.upanghub.model.Park
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecurityParkActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecurityParkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecurityParkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getParkList()
        binding.apply {
            btnP1.setOnClickListener {
                // Define color constants

                show(1)


            }
            btnP2.setOnClickListener {
                show(2)

            }
            btnP3.setOnClickListener {
                show(3)

            }
            btnP4.setOnClickListener {
                show(4)

            }
            btnP5.setOnClickListener {
                show(5)

            }
            btnP6.setOnClickListener {
                show(6)

            }
            btnP7.setOnClickListener {
                show(7)

            }
            btnP8.setOnClickListener {
                show(8)

            }
            btnP9.setOnClickListener {
                show(9)

            }
            btnP10.setOnClickListener {
                show(10)

            }

        }
    }

    private fun show(id: Int){
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.showParking(id)
        call.enqueue(object : Callback<Park> {
            override fun onResponse(p0: Call<Park>, p1: Response<Park>) {
                if(p1.isSuccessful){
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                   val parkStatus = p1.body()?.status
                    when(parkStatus){
                        "available"->{
                            occupied(id)
                            finish()
                            startActivity(intent)

                        }
                        "occupied" -> {
                            available(id)
                            finish()
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onFailure(p0: Call<Park>, p1: Throwable) {

            }

        })
    }
    private fun occupied(id:Int){
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.occupied(id)
        call.enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                if(p1.isSuccessful){
                    Toast.makeText(applicationContext, "occupied", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {
                Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun available(id:Int){
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.available(id)
        call.enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                if(p1.isSuccessful){
                    Toast.makeText(applicationContext, "available", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {

                Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun getParkList() {
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.getParkList()
        binding.progressBar.isVisible = true
        call.enqueue(object : Callback<List<Park>> {
            override fun onResponse(call: Call<List<Park>>, response: Response<List<Park>>) {
                if (response.isSuccessful) {
                    binding.progressBar.isVisible = false
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
                binding.progressBar.isVisible = false
            }
        })
    }
}