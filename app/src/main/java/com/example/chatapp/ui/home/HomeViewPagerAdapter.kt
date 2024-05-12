package com.example.chatapp.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewPagerAdapter(private val fragmentList: MutableList<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle)  : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
      return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}