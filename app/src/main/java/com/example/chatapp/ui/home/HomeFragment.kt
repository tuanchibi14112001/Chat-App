package com.example.chatapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentHomeBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.friend.FriendFragment
import com.example.chatapp.ui.message.MessageFragment
import com.example.chatapp.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var pagerHome: ViewPager2
    private lateinit var fragmentArrayList: MutableList<Fragment>
    private lateinit var homeAdapter: HomeViewPagerAdapter
    private lateinit var bottomNavView: BottomNavigationView
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun prepareView(savedInstanceState: Bundle?) {
        initBottomNavigationBar()
    }

    private fun initBottomNavigationBar() {
        //xay dung viewpager
        pagerHome = binding.homePager
        fragmentArrayList = mutableListOf()
        fragmentArrayList.add(MessageFragment())
        fragmentArrayList.add(FriendFragment())
        fragmentArrayList.add(ProfileFragment())
        homeAdapter = HomeViewPagerAdapter(fragmentArrayList, requireActivity().supportFragmentManager, lifecycle)
        pagerHome.adapter = homeAdapter

        //xay dung bottom nav
        bottomNavView = binding.homeNav
        bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navMessage -> pagerHome.currentItem = 0
                R.id.navFriend -> pagerHome.currentItem = 1
                R.id.navProfile -> pagerHome.currentItem = 2
            }
            true
        }
        pagerHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val menuItem = bottomNavView.menu.getItem(position)
                bottomNavView.selectedItemId = menuItem.itemId
            }
        })
    }

}