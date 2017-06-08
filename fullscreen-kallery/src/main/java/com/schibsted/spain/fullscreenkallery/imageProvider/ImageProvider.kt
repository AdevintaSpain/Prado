package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.widget.ImageView


interface ImageProvider {
  fun loadImage(context: Context, imageUrl: String, imageView: ImageView, onImageSuccess: () -> Unit, onImageError: () -> Unit)
}