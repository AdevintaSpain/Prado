package com.schibsted.spain.fullscreenkallery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.schibsted.spain.fullscreenkallery.adapter.GalleryRecyclerAdapter
import com.schibsted.spain.fullscreenkallery.imageProvider.PicassoImageProvider
import kotlinx.android.synthetic.main.activity_fullscreen_gallery.*

class FullscreenGalleryActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LIST_ITEMS = "EXTRA_LIST_ITEMS"
        val EXTRA_LIST_INITIAL_INDEX = "EXTRA_LIST_INITIAL_INDEX"
        val EXTRA_LIST_FINAL_INDEX = "EXTRA_LIST_FINAL_INDEX"
        val REQUEST_CODE = 1
        val INITIAL_INDEX = 0
        private val BUNDLE_PAGE_NUMBER = "BUNDLE_PAGE_NUMBER"
    }

    lateinit private var pagerIndicatorNumber: TextView
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
    }

    private fun setupGalleryViewPager() {
        galleryViewPager.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var adapter = GalleryRecyclerAdapter(this, items, PicassoImageProvider.getInstance(this))
    }
}
