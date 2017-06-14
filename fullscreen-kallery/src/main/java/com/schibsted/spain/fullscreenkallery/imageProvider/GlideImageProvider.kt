package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.fullscreenkallery.extensions.centerInParent
import java.lang.Exception


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
        .into(KalleryTarget(imageView, PhotoViewAttacher(imageView)))
  }
}

class KalleryTarget(val imageView: ImageView, val photoViewAttacher: PhotoViewAttacher) : GlideDrawableImageViewTarget(imageView) {

  override fun onLoadStarted(placeholder: Drawable?) {
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    imageView.centerInParent()
    super.onLoadStarted(placeholder)
  }

  override fun onLoadFailed(e: Exception?, errorDrawable: Drawable?) {
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    imageView.centerInParent()
    super.onLoadFailed(e, errorDrawable)
  }

  override fun onResourceReady(resource: GlideDrawable?, animation: GlideAnimation<in GlideDrawable>?) {
    imageView.scaleType = ImageView.ScaleType.MATRIX
    imageView.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
    photoViewAttacher.update()
    super.onResourceReady(resource, null)
  }
}