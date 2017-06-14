package com.schibsted.spain.fullscreenkallery.imageProvider

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.fullscreenkallery.extensions.centerInParent
import java.lang.Exception


internal class KalleryGlideTarget(val imageView: ImageView, val photoViewAttacher: PhotoViewAttacher) : GlideDrawableImageViewTarget(imageView) {

  override fun onLoadStarted(placeholder: Drawable?) {
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    imageView.centerInParent(RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT))
    super.onLoadStarted(placeholder)
  }

  override fun onLoadFailed(e: Exception?, errorDrawable: Drawable?) {
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    imageView.centerInParent(RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT))
    super.onLoadFailed(e, errorDrawable)
  }

  override fun onResourceReady(resource: GlideDrawable?, animation: GlideAnimation<in GlideDrawable>?) {
    imageView.scaleType = ImageView.ScaleType.MATRIX
    imageView.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
    photoViewAttacher.update()
    super.onResourceReady(resource, null)
  }
}