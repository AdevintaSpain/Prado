package com.schibsted.spain.fullscreenkallery.recyclerviewpager

import android.content.Context
import android.view.MotionEvent
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager


class HackyRecyclerViewPager(context: Context) : RecyclerViewPager(context) {
    override fun onInterceptTouchEvent(e: MotionEvent?) = try {
        super.onInterceptTouchEvent(e)
    } catch (e: IllegalArgumentException) {
        false
    }
}