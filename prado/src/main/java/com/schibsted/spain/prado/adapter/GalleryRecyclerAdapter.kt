package com.schibsted.spain.prado.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.prado.extensions.inflate
import com.schibsted.spain.prado.imageProvider.ImageProvider

class GalleryRecyclerAdapter(val context: Context, val items: List<String>, val imageProvider: ImageProvider)
  : RecyclerView.Adapter<GalleryViewHolder>() {

  lateinit var imageView: ImageView

  init {
    setHasStableIds(true)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
    val row = parent.inflate(R.layout.item_gallery)
    return provideViewHolder(row)
  }

  fun provideViewHolder(row: View) = GalleryViewHolder(row)

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
    imageView = holder.itemImage
    loadImage(items[position])
  }

  override fun getItemId(position: Int): Long {
    return items[position].hashCode().toLong()
  }

  private fun loadImage(imageUrl: String) {
    if (imageUrl.isNullOrEmpty()) {
      showError()
    } else {
      loadImageFromUrl(imageUrl)
    }
  }

  private fun showError() {
    imageProvider.loadError(context, imageView)
  }

  private fun loadImageFromUrl(imageUrl: String) {
    imageProvider.loadImage(context, imageUrl, imageView)
  }
}

