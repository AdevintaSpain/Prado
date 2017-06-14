package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.widget.ImageView
import android.widget.RelativeLayout
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.jakewharton.picasso.OkHttp3Downloader
import com.schibsted.spain.fullscreenkallery.BuildConfig
import com.schibsted.spain.fullscreenkallery.R
import com.schibsted.spain.fullscreenkallery.extensions.centerInParent
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class PicassoImageProvider(context: Context) : ImageProvider {

  var picasso: Picasso

  init {
    val picassoBuilder = Picasso.Builder(context)

    val client = OkHttpClient().newBuilder()
        .cache(OkHttp3Downloader.createDefaultCache(context))
        .addInterceptor(
            HttpLoggingInterceptor().apply {
              level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
        )
        .build()

    picasso = picassoBuilder.downloader(OkHttp3Downloader(client)).build()
  }

  override fun loadError(context: Context, imageView: ImageView) {
    imageView.scaleType = ImageView.ScaleType.FIT_CENTER
    imageView.centerInParent(RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT))
    picasso.load(R.drawable.nophoto).into(imageView)
  }

  override fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
    val photoViewAttacher = PhotoViewAttacher(imageView)

    picasso.load(imageUrl)
        .noFade()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.nophoto)
        .into(imageView, object : Callback { // TODO try Callback extension into({},{})
          override fun onSuccess() {
            imageView.scaleType = ImageView.ScaleType.MATRIX
            imageView.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
            photoViewAttacher.update()
          }

          override fun onError() {
          }
        })
  }
}