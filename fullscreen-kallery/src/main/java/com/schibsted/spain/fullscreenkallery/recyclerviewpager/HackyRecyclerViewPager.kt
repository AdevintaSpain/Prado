package com.schibsted.spain.fullscreenkallery.recyclerviewpager

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * This class is because this issue: https://github.com/chrisbanes/PhotoView#issues-with-viewgroups
 */
class HackyRecyclerViewPager(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

  override fun onInterceptTouchEvent(e: MotionEvent?) = try {
    super.onInterceptTouchEvent(e)
  } catch (e: IllegalArgumentException) {
    false
  }
}