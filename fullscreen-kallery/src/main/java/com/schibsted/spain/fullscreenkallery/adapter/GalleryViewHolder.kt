package com.schibsted.spain.fullscreenkallery.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView


abstract class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun getImageView(): ImageView
}