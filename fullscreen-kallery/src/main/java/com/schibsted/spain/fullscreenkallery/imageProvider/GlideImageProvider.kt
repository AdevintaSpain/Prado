package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.fullscreenkallery.extensions.centerInParent


class GlideImageProvider : ImageProvider {

  override fun loadError(context: Context, imageView: ImageView) {
    imageView.centerInParent()
    Glide.with(context).load(R.drawable.nophoto).into(imageView)
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
    Glide.with(context)
        .load(imageUrl)
        .error(R.drawable.nophoto)
        .placeholder(R.drawable.placeholder)
        .into(KalleryGlideTarget(imageView, PhotoViewAttacher(imageView)))
  }
}