package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.fullscreenkallery.R


class GlideImageProvider : ImageProvider {

  override fun loadError(context: Context, imageView: ImageView) {
    loadImage(context, "", imageView)
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
    Glide.with(context)
        .load(imageUrl)
        .error(R.drawable.nophoto)
        .placeholder(R.drawable.placeholder)
        .thumbnail(0.01f)
        .into(KalleryGlideTarget(imageView, PhotoViewAttacher(imageView)))
  }
}