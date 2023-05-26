package com.es.gng.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.es.gng.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}