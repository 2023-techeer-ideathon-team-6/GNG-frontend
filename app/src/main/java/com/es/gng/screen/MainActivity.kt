package com.es.gng.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.es.gng.R
import com.es.gng.databinding.ActivityMainBinding
import com.es.gng.screen.onboard.OnBoardActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var temp = intent.getIntExtra("daeYoung", 0)
        Log.d("daeYoung", "$temp")
        if (temp == 0) {
            Log.d("daeYoung", "if문 안에: $temp")
            finish()
            startActivity(Intent(this, OnBoardActivity::class.java))

        }


        binding.shareBtn.setOnClickListener {
            val intent = Intent(this, SharedActivity::class.java)
            startActivity(intent)

        }
        binding.sharedBtn.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

    }
}