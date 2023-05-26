package com.es.gng.screen.onboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.es.gng.R
import com.es.gng.databinding.ActivityOnBoardBinding
import com.es.gng.screen.MainActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnBoardActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var indicator: DotsIndicator
    lateinit var nextBtn: Button
    lateinit var backBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager2
        indicator = binding.indicator
        nextBtn = binding.nextButton
        backBtn = binding.backButton

        viewPager.adapter = OnBoardFragmentPagerAdapter(this)
        indicator.setViewPager2(viewPager)


        nextBtn.setOnClickListener {
            when(viewPager.currentItem) {
                0 -> {
                    viewPager.currentItem = 1
                    backBtn.isEnabled = true
                }
                1 -> {
                    viewPager.currentItem = 2
                }
                2 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("daeYoung", 1)
                    startActivity(intent)
                    finish()
                }

            }
        }

        backBtn.setOnClickListener {
            when(viewPager.currentItem) {
                1 -> {
                    viewPager.currentItem = 0
                    backBtn.isEnabled = false
                }
                2 -> {
                    viewPager.currentItem = 1
                }
            }
        }


    }
}