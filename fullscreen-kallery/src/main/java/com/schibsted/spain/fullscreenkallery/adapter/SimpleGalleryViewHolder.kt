package com.schibsted.spain.fullscreenkallery.adapter

import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_gallery.view.*


class SimpleGalleryViewHolder(itemView: View) : GalleryViewHolder(itemView) {

    var itemImage : ImageView = itemView.itemImage
    var itemImagePlaceholder : ImageView = itemView.itemImagePlaceholder
    var itemImageError : ImageView = itemView.itemImageError

    override fun getImageView() = itemImage
}