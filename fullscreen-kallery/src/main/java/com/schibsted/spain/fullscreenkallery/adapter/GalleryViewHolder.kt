package com.schibsted.spain.fullscreenkallery.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_gallery.view.*


class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var itemImage: ImageView = itemView.itemImage
  var itemImagePlaceholder: ImageView = itemView.itemImagePlaceholder
  var itemImageError: ImageView = itemView.itemImageError
}