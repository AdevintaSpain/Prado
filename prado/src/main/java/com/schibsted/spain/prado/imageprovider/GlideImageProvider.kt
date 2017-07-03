package com.schibsted.spain.prado.imageprovider

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.prado.R
import com.schibsted.spain.prado.throwable.ImageProviderNotAvailableError


class GlideImageProvider(context: Context) : ImageProvider {

  companion object {
    private val IMAGE_QUALITY_1_PERCENT = 0.01f
  }

  var glide: RequestManager

  init {
    try {
      glide = Glide.with(context)
    } catch (ncdfe: NoClassDefFoundError) {
      throw ImageProviderNotAvailableError("Glide not available")
    }
  }

  override fun loadError(context: Context, imageView: ImageView) {
    loadImage(context, "", imageView)
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
    glide.load(imageUrl)
        .error(R.drawable.nophoto)
        .placeholder(R.drawable.placeholder)
        .thumbnail(IMAGE_QUALITY_1_PERCENT)
        .into(GlideDrawablePhotoViewAttacherTarget(imageView, PhotoViewAttacher(imageView)))
  }
}