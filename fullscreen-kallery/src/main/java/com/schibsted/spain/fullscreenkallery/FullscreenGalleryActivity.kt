package com.schibsted.spain.fullscreenkallery

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.schibsted.spain.fullscreenkallery.adapter.GalleryRecyclerAdapter
import com.schibsted.spain.fullscreenkallery.extensions.buildFullscreenGalleryIntent
import com.schibsted.spain.fullscreenkallery.imageProvider.GlideImageProvider
import com.schibsted.spain.fullscreenkallery.imageProvider.PicassoImageProvider
import kotlinx.android.synthetic.main.activity_fullscreen_gallery.*

class FullscreenGalleryActivity : AppCompatActivity() {

  companion object {
    val EXTRA_LIST_ITEMS = "EXTRA_LIST_ITEMS"
    val EXTRA_LIST_INITIAL_INDEX = "EXTRA_LIST_INITIAL_INDEX"
    val EXTRA_LIST_FINAL_INDEX = "EXTRA_LIST_FINAL_INDEX"
    val INITIAL_INDEX = 0
    private val BUNDLE_PAGE_NUMBER = "BUNDLE_PAGE_NUMBER"

    @JvmStatic
    fun buildFullscreenGalleryIntent(context: Context, imageUrls: List<String>): Intent {
      return context.buildFullscreenGalleryIntent(imageUrls)
    }
  }

  private var totalItems: Int = 0
  private var currentIndex: Int = 0
  private var items: List<String> = arrayListOf()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_fullscreen_gallery)

    if (intent.hasExtra(EXTRA_LIST_ITEMS)) {
      items = intent.getStringArrayListExtra(EXTRA_LIST_ITEMS)
    }
    totalItems = items.size

    setupGalleryViewPager()

    initCloseIcon()

    initPageIndicator(savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt(BUNDLE_PAGE_NUMBER, currentIndex)
  }

  override fun onBackPressed() {
    setGalleryResult()
    super.onBackPressed()
  }

  private fun setupGalleryViewPager() {
    galleryViewPager.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    galleryViewPager.adapter = GalleryRecyclerAdapter(this, items, provideImageProvider())
//    FIXME galleryViewPager.recycledViewPool.setMaxRecycledViews(0, 0)

    val snapHelper = GravityPagerSnapHelper(Gravity.START, true, GravitySnapHelper.SnapListener {
      position -> pagerIndicatorNumber.text = providePagerIndicatorText(position) })
    snapHelper.attachToRecyclerView(galleryViewPager)
  }

  private fun provideImageProvider() = GlideImageProvider.getInstance(this)

  private fun initCloseIcon() {
    galleryCloseIcon.setOnClickListener {
      setGalleryResult()
      finish()
    }
  }

  private fun setGalleryResult() {
    val data = Intent()
    data.putExtra(EXTRA_LIST_FINAL_INDEX, currentIndex - 1)
    setResult(Activity.RESULT_OK, data)
  }

  private fun initPageIndicator(savedInstanceState: Bundle?) {
    if (savedInstanceState != null) {
      currentIndex = savedInstanceState.getInt(BUNDLE_PAGE_NUMBER)
    } else {
      currentIndex = intent.getIntExtra(EXTRA_LIST_INITIAL_INDEX, INITIAL_INDEX)
    }
    pagerIndicatorNumber.text = providePagerIndicatorText(currentIndex)
    galleryViewPager.scrollToPosition(currentIndex)
  }

  private fun providePagerIndicatorText(index: Int): String {
    this.currentIndex = index
    return String.format(resources.getString(R.string.pageIndicator_text_number), currentIndex + 1, totalItems)
  }
}
