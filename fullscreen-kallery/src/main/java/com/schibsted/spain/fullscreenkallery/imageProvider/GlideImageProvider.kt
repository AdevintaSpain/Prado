package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.fullscreenkallery.extensions.calculateViewSize
import java.lang.Exception
import java.util.concurrent.atomic.AtomicBoolean


class GlideImageProvider private constructor(context: Context) : ImageProvider {

  var windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

  companion object {
    private lateinit var INSTANCE: GlideImageProvider
    private val initialized = AtomicBoolean()

    fun getInstance(context: Context): GlideImageProvider {
      if (!initialized.getAndSet(true)) {
        INSTANCE = GlideImageProvider(context)
      }
      return INSTANCE
    }
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView, onImageSuccess: () -> Unit, onImageError: () -> Unit) {
    val viewSize = windowManager.calculateViewSize(context)

    val photoViewAttacher = addImageInteractions(imageView)

    Glide.with(context)
        .load(imageUrl)
        .asBitmap()
//        .override(viewSize.width, viewSize.height)
        .fitCenter()
        .into(KalleryTarget(imageView, photoViewAttacher, onImageSuccess, onImageError))
  }

  private fun addImageInteractions(imageView: ImageView): PhotoViewAttacher {
    val photoViewAttacher = PhotoViewAttacher(imageView)
    imageView.scaleType = ImageView.ScaleType.MATRIX
    return photoViewAttacher
  }
}

class KalleryTarget(val imageView: ImageView, val photoViewAttacher: PhotoViewAttacher, val onImageSuccess: () -> Unit,
                    val onImageError: () -> Unit) : SimpleTarget<Bitmap>() {
  override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
    imageView.setImageBitmap(resource)
    photoViewAttacher.update()
    onImageSuccess()
  }

  override fun onLoadFailed(e: Exception?, errorDrawable: Drawable?) {
    super.onLoadFailed(e, errorDrawable)
    onImageError()
  }
}