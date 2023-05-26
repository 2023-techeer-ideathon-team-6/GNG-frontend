package com.es.gng.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.es.gng.R
import com.es.gng.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shareBtn.setOnClickListener {
            val intent = Intent(this, SharedActivity::class.java)
            startActivity(intent)

        }

    }
}