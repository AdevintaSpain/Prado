package com.schibsted.spain.fullscreenkallery.adapter

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.BitmapRequestBuilder
import com.bumptech.glide.GenericRequestBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.fullscreenkallery.extensions.inflate
import com.schibsted.spain.fullscreenkallery.imageProvider.ImageProvider

class GalleryRecyclerAdapter(val context: Context, val items: List<String>, val imageProvider: ImageProvider)
  : RecyclerView.Adapter<GalleryViewHolder>(), ListPreloader.PreloadModelProvider<String>, ListPreloader.PreloadSizeProvider<String> {

  override fun getPreloadSize(item: String?, adapterPosition: Int, perItemPosition: Int) = stolenSize

  override fun getPreloadRequestBuilder(item: String?): GenericRequestBuilder<*, *, *, *> = builder.load(item)

  override fun getPreloadItems(position: Int): MutableList<String> = arrayListOf(items[position])

  lateinit var imageView: ImageView
  var builder: BitmapRequestBuilder<String, Bitmap>
  private var stolenSize: IntArray? = null

  init {
    setHasStableIds(true)
    builder = Glide.with(context).fromString().asBitmap().fitCenter()
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

