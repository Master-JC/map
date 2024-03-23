package com.fourinone.finalproject.block2.upanghub

import android.graphics.PointF
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.fourinone.finalproject.block2.upanghub.databinding.ActivityMainBinding
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//sda
        // Initialize buttons
        binding.zoomableImageView.setImage(ImageSource.resource(R.drawable.itona))

    }


}
