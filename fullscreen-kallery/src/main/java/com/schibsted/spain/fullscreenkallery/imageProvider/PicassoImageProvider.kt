package com.schibsted.spain.fullscreenkallery.imageProvider

import android.content.Context
import android.view.WindowManager
import android.widget.ImageView
import com.jakewharton.picasso.OkHttp3Downloader
import com.schibsted.spain.fullscreenkallery.BuildConfig
import com.schibsted.spain.fullscreenkallery.extensions.isLandscape
import com.schibsted.spain.fullscreenkallery.extensions.screenHeight
import com.schibsted.spain.fullscreenkallery.extensions.screenWidth
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.atomic.AtomicBoolean


class PicassoImageProvider private constructor(context: Context) : ImageProvider {

    var picasso: Picasso
    var windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    lateinit private var onInternalError: OnInternalError

    companion object {
        private lateinit var INSTANCE: PicassoImageProvider
        private val initialized = AtomicBoolean()

        fun getInstance(context: Context): PicassoImageProvider {
            if (initialized.getAndSet(true)) {
                INSTANCE = PicassoImageProvider(context)
            }
            return INSTANCE
        }
    }

    init {
        val picassoBuilder = Picasso.Builder(context)
        picassoBuilder.listener { picasso, _, _ -> onInternalError.onError(picasso) }

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

    override fun loadImage(context: Context, imageUrl: String, imageView: ImageView, onImageSuccess: () -> Unit, onImageError: () -> Unit) {
        val viewSize = calculateViewSize(context)
        onInternalError = OnInternalError(imageView, onImageError)

        picasso.load(imageUrl)
                .noFade()
                .noPlaceholder()
                .resize(viewSize.width, viewSize.height)
                .into(imageView, object : Callback {
                    override fun onSuccess() = onImageSuccess()
                    override fun onError() = Unit
                })
    }

    private fun calculateViewSize(context: Context): ViewSize {
        var width = 0
        var height = 0

        if (context.isLandscape()) {
            height = windowManager.screenHeight
        } else {
            width = windowManager.screenWidth
        }

        return ViewSize(width, height)
    }

    private class OnInternalError(val imageView: ImageView, val onImageError: () -> Unit) {
        fun onError(aPicasso: Picasso) {
            aPicasso.cancelRequest(imageView)
            onImageError()
        }
    }

}