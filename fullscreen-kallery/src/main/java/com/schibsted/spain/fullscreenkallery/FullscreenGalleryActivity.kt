package com.schibsted.spain.fullscreenkallery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.schibsted.spain.fullscreenkallery.adapter.GalleryRecyclerAdapter
import com.schibsted.spain.fullscreenkallery.imageProvider.PicassoImageProvider
import kotlinx.android.synthetic.main.activity_fullscreen_gallery.*

class FullscreenGalleryActivity : AppCompatActivity() {

  companion object {
    val EXTRA_LIST_ITEMS = "EXTRA_LIST_ITEMS"
    val EXTRA_LIST_INITIAL_INDEX = "EXTRA_LIST_INITIAL_INDEX"
    val EXTRA_LIST_FINAL_INDEX = "EXTRA_LIST_FINAL_INDEX"
    val INITIAL_INDEX = 0
    private val BUNDLE_PAGE_NUMBER = "BUNDLE_PAGE_NUMBER"
  }

  private var totalItems: Int = 0
  private var currentPage: Int = 0
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
    outState.putInt(BUNDLE_PAGE_NUMBER, currentPage)
  }

  override fun onBackPressed() {
    setGalleryResult()
    super.onBackPressed()
  }

  private fun setupGalleryViewPager() {
    galleryViewPager.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    galleryViewPager.adapter = GalleryRecyclerAdapter(this, items, PicassoImageProvider.getInstance(this))

    val snapHelper = GravityPagerSnapHelper(Gravity.START, false, GravitySnapHelper.SnapListener { position -> pagerIndicatorNumber.text = providePagerIndicatorText(position + 1, totalItems) })
    snapHelper.attachToRecyclerView(galleryViewPager)
  }

  private fun initCloseIcon() {
    galleryCloseIcon.setOnClickListener {
      setGalleryResult()
      finish()
    }
  }

  private fun setGalleryResult() {
    val data = Intent()
    data.putExtra(EXTRA_LIST_FINAL_INDEX, currentPage - 1)
    setResult(Activity.RESULT_OK, data)
  }

  private fun initPageIndicator(savedInstanceState: Bundle?) {
    if (savedInstanceState != null) {
      currentPage = savedInstanceState.getInt(BUNDLE_PAGE_NUMBER)
    } else {
      currentPage = intent.getIntExtra(EXTRA_LIST_INITIAL_INDEX, INITIAL_INDEX)
    }
    pagerIndicatorNumber.text = providePagerIndicatorText(currentPage, totalItems)
    galleryViewPager.scrollToPosition(currentPage)
  }

  private fun providePagerIndicatorText(page: Int, totalPages: Int): String {
    this.currentPage = page
    return String.format(resources.getString(R.string.pageIndicator_text_number), currentPage, totalPages)
  }
}
