package com.schibsted.spain.fullscreenkallery.extensions

import android.os.Build
import android.widget.ImageView


fun ImageView.drawableCompat(placeHolderResource: Int) {
  if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
    this.setImageDrawable(context.resources.getDrawable(placeHolderResource))
  } else {
    this.setImageDrawable(context.resources.getDrawable(placeHolderResource, null))
  }

}

