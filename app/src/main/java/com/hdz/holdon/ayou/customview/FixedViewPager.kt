package com.hdz.holdon.ayou.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class FixedViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean = false

    override fun onTouchEvent(ev: MotionEvent?): Boolean = false

    override fun setCurrentItem(item: Int) {
        this.setCurrentItem(item, false)
    }

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        super.setCurrentItem(item, smoothScroll)
    }
}