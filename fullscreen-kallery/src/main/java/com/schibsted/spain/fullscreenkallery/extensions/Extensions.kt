package com.schibsted.spain.fullscreenkallery.extensions

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.schibsted.spain.fullscreenkallery.FullscreenGalleryActivity
import com.schibsted.spain.fullscreenkallery.imageProvider.ViewSize


fun ViewGroup.inflate(layoutRes: Int): View {
  return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

val WindowManager.screenWidth: Int get() {
  val point = Point()
  this.defaultDisplay.getSize(point)
  return point.x
}

val WindowManager.screenHeight: Int get() {
  val point = Point()
  this.defaultDisplay.getSize(point)
  return point.y
}

fun WindowManager.calculateViewSize(context: Context): ViewSize {
  var width = 0
  var height = 0

  if (context.isLandscape()) {
    height = screenHeight
  } else {
    width = screenWidth
  }

  return ViewSize(width, height)
}

fun Context.isLandscape(): Boolean {
  return Configuration.ORIENTATION_LANDSCAPE == this.resources.configuration.orientation
}

fun Context.buildFullscreenGalleryIntent(imageUrls: List<String>): Intent {
  val imageUrlsArrayList: ArrayList<String>
  when (imageUrls) {
    is ArrayList -> imageUrlsArrayList = imageUrls
    else -> {
      imageUrlsArrayList = arrayListOf<String>()
      imageUrls.forEach { imageUrlsArrayList.add(it) }
    }
  }
  return Intent(this, FullscreenGalleryActivity::class.java)
      .putStringArrayListExtra(FullscreenGalleryActivity.EXTRA_LIST_ITEMS, imageUrlsArrayList)
}


