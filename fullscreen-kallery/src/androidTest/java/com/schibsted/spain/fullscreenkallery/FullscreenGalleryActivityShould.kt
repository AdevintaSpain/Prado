package com.schibsted.spain.fullscreenkallery

import android.content.Intent
import com.schibsted.spain.barista.BaristaAssertions.assertRecyclerViewItemCount
import com.schibsted.spain.barista.BaristaRule
import org.junit.Rule
import org.junit.Test

class FullscreenGalleryActivityShould {

  @get:Rule
  val activityRule: BaristaRule<FullscreenGalleryActivity> = BaristaRule.create(FullscreenGalleryActivity::class.java)

  @Test
  fun create_a_5_element_gallery() {
    activityRule.launchActivity(givenA5imageUrlsIntent())

    assertRecyclerViewItemCount(R.id.galleryViewPager, 5)
  }

  private fun givenA5imageUrlsIntent(): Intent? {
    val intent = Intent()

    val imageUrls = arrayListOf("", "", "", "", "")
    intent.putStringArrayListExtra(FullscreenGalleryActivity.EXTRA_LIST_ITEMS, imageUrls)

    return intent
  }
}