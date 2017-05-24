package com.schibsted.spain.fullscreenkallery.recyclerviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager


class HackyRecyclerViewPager(context: Context, attrs: AttributeSet) : RecyclerViewPager(context, attrs) {

    override fun onInterceptTouchEvent(e: MotionEvent?) = try {
        super.onInterceptTouchEvent(e)
    } catch (e: IllegalArgumentException) {
        false
    }
}