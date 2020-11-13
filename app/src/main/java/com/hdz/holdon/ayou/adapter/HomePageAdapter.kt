package com.hdz.holdon.ayou.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HomePageAdapter(fragmentManager: FragmentManager, fragmentList: List<Fragment>) :
    FragmentStatePagerAdapter(fragmentManager) {

    var fragmentManager: FragmentManager
    var fragmentList: List<Fragment>

    init {
        this.fragmentList = fragmentList
        this.fragmentManager = fragmentManager
    }

    override fun getItem(position: Int): Fragment = fragmentList.get(position)

    override fun getCount(): Int = fragmentList.size
}