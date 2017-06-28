package com.schibsted.spain.prado.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_gallery.view.*


class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var itemImage: ImageView = itemView.itemImage
}