package com.schibsted.spain.prado.extensions

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.schibsted.spain.prado.PradoGalleryActivity
import com.schibsted.spain.prado.imageProvider.ImageProvider
import com.squareup.picasso.Callback
import com.squareup.picasso.RequestCreator


fun ViewGroup.inflate(layoutRes: Int): View {
  return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun Context.buildPradoGalleryIntent(imageUrls: List<String>,
                                    imageProviderType: ImageProvider.ImageProviderType = ImageProvider.ImageProviderType.PICASSO): Intent {
  val imageUrlsArrayList = when (imageUrls) {
    is ArrayList -> imageUrls
    else -> ArrayList(imageUrls)
  }
  return Intent(this, PradoGalleryActivity::class.java)
      .putStringArrayListExtra(PradoGalleryActivity.EXTRA_LIST_ITEMS, imageUrlsArrayList)
      .putExtra(PradoGalleryActivity.EXTRA_IMAGE_PROVIDER, imageProviderType.name)
}

fun ImageView.centerInParent(relativeLayoutParams: RelativeLayout.LayoutParams) {
  relativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
  layoutParams = relativeLayoutParams
}

fun RequestCreator.into(imageView: ImageView, onImageSuccess: () -> Unit) {
  into(imageView, object : Callback {
    override fun onSuccess() {
      onImageSuccess()
    }

    override fun onError() {
    }
  })
}


