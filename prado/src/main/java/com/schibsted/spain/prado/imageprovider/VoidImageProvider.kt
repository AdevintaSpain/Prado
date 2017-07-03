package com.schibsted.spain.prado.imageprovider

import android.content.Context
import android.widget.ImageView


class VoidImageProvider : ImageProvider {
  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {

  }

  override fun loadError(context: Context, imageView: ImageView) {

  }
}