package com.fourinone.finalproject.block2.upanghub

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.fourinone.finalproject.block2.upanghub.databinding.ActivityRoomViewBinding
import com.fourinone.finalproject.block2.upanghub.model.Room
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomViewBinding
    private var url: String? = null
    private var id:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        id = intent.getStringExtra("key")
        id?.let { getRoom(it.toInt()) }


    }
    private fun getRoom(id:Int)
    {
        val retrofit = Retrofitbuilder.buildService(ApiService::class.java)
        val call = retrofit.getRoom(id)

        call.enqueue(object : Callback<Room> {
            override fun onResponse(p0: Call<Room>, p1: Response<Room>) {
                if (p1.isSuccessful){
                    url = p1.body()?.img!!
                    val imageUrl = "http://10.40.70.87/${url}"
                    // Assuming 'zoomableImageView' is defined in the layout file associated with YourActivityBinding
                    Glide.with(applicationContext)
                        .load(imageUrl)
                        .into(object : CustomTarget<Drawable>() {
                            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                                // Set the loaded image to zoomableImageView (SubsamplingScaleImageView)
                                binding.zoomableImageView.setImage(ImageSource.bitmap(resource.toBitmap()))

                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                // Placeholder or previously set image has been cleared
                                // Handle this if needed
                            }
                        })
                }
            }

            override fun onFailure(p0: Call<Room>, p1: Throwable) {
                TODO("Not yet implemented")
                Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
            }

        })
    }


}