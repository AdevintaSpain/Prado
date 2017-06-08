package com.schibsted.spain.fullscreenkallery.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.fullscreenkallery.extensions.drawableCompat
import com.schibsted.spain.fullscreenkallery.extensions.inflate
import com.schibsted.spain.fullscreenkallery.imageProvider.ImageProvider

class GalleryRecyclerAdapter(val context: Context, val items: List<String>, val imageProvider: ImageProvider)
  : RecyclerView.Adapter<GalleryViewHolder>() {

  lateinit var imageView: ImageView
  lateinit var imagePlaceHolder: ImageView
  lateinit var imageError: ImageView

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
    val row = parent.inflate(R.layout.item_gallery)
    return provideViewHolder(row)
  }

  fun provideViewHolder(row: View) = GalleryViewHolder(row)

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
    imageView = holder.itemImage
    imagePlaceHolder = holder.itemImagePlaceholder
    imageError = holder.itemImageError

    imageError.drawableCompat(R.drawable.nophoto)
    imagePlaceHolder.drawableCompat(R.drawable.placeholder)

    loadImage(items[position])
  }

  private fun loadImage(imageUrl: String) {
    if (imageUrl.isNullOrEmpty()) {
      showError()
    } else {
      showPlaceHolder()
      loadImageFromUrl(imageUrl)
    }
  }

  private fun loadImageFromUrl(imageUrl: String) {
    imageProvider.loadImage(context, imageUrl, imageView, { showImage() }, { showError() })
  }

  private fun showPlaceHolder() {
    imageView.visibility = View.GONE
    imagePlaceHolder.visibility = View.VISIBLE
    imageError.visibility = View.GONE
  }

  private fun showError() {
    imageView.visibility = View.GONE
    imagePlaceHolder.visibility = View.GONE
    imageError.visibility = View.VISIBLE
  }

  private fun showImage() {
    imageView.visibility = View.VISIBLE
    imagePlaceHolder.visibility = View.GONE
    imageError.visibility = View.GONE
  }
}

