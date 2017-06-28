package com.schibsted.spain.prado.imageprovider

import android.content.Context
import android.widget.ImageView

interface ImageProvider {

  enum class ImageProviderType {
    PICASSO, GLIDE
  }

  fun loadImage(context: Context, imageUrl: String, imageView: ImageView)
  fun loadError(context: Context, imageView: ImageView)
}