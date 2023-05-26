package com.es.gng.screen.onboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val fragments: List<Fragment>
    init {
        fragments = listOf(OnBoard1Fragment(), OnBoard2Fragment(), OnBoard3Fragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun nextFragment() {

    }

}