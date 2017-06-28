package com.schibsted.spain.prado.imageprovider

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.prado.R


class GlideImageProvider : ImageProvider {

  companion object {
    private val IMAGE_QUALITY_1_PERCENT = 0.01f
  }

  override fun loadError(context: Context, imageView: ImageView) {
    loadImage(context, "", imageView)
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
    Glide.with(context)
        .load(imageUrl)
        .error(R.drawable.nophoto)
        .placeholder(R.drawable.placeholder)
        .thumbnail(IMAGE_QUALITY_1_PERCENT)
        .into(GlideDrawablePhotoViewAttacherTarget(imageView, PhotoViewAttacher(imageView)))
  }
}