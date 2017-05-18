package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.widget.ImageView


interface ImageProvider {

    fun loadImage(context: Context, imageUrl: String, imageView: ImageView,
                  onImageSuccess: OnImageSuccess, onImageError: OnImageError)


    interface OnImageSuccess {
        fun onSuccess()
    }

    interface OnImageError {
        fun onError()
    }
}