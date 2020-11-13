package com.hdz.holdon.ayou

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.ButterKnife
import com.hdz.holdon.R
import com.hdz.holdon.ayou.adapter.HomePageAdapter
import com.hdz.holdon.ayou.fragment.HomeFragment
import com.hdz.holdon.ayou.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), View.OnClickListener {

    lateinit var mAdapter: HomePageAdapter

    lateinit var mHomeFragment: HomeFragment
    lateinit var mMineFragment: MineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        init()
    }

    fun init() {
        radiogroup_main.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                when (checkedId) {
                    R.id.radio_mine_main -> {
                        viewpager_main.setCurrentItem(1)
                    }
                    R.id.radio_home_main -> {
                        viewpager_main.setCurrentItem(0)
                    }
                }
            }
        })
        val fragmentList = ArrayList<Fragment>(2)
        mHomeFragment = HomeFragment()
        mMineFragment = MineFragment()
        fragmentList.add(mHomeFragment)
        fragmentList.add(mMineFragment)
        mAdapter = HomePageAdapter(supportFragmentManager, fragmentList)
        viewpager_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }
        })
        viewpager_main.adapter = mAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_pic_main -> {

            }
        }
    }


}
