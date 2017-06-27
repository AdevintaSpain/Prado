package com.schibsted.spain.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.schibsted.spain.prado.extensions.buildPradoGalleryIntent
import com.schibsted.spain.prado.imageprovider.ImageProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val imageUrlsList = arrayListOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/The_Simpsons_Logo.svg/2000px-The_Simpsons_Logo.svg.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Homer/swsb_character_fact_homer_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Marge/swsb_character_fact_marge_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_bart_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Lisa/swsb_character_fact_lisa_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Maggie/swsb_character_fact_maggie_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_snowball_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_santaslittlehelper_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Krusty/swsb_character_fact_krusty_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_sideshowmel_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_krabappel_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_skinner_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_cletus_550x960.png",
        "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_brandine_550x960.png",
        "http://vignette4.wikia.nocookie.net/lossimpson/images/c/c4/The_Simpsons_characters.png/revision/20110629063200?path-prefix=es",
        ""
    )

    launcherPicassoButton.setOnClickListener {
      startActivity(buildPradoGalleryIntent(imageUrlsList))
    }

    launcherGlideButton.setOnClickListener {
      startActivity(buildPradoGalleryIntent(imageUrlsList, ImageProvider.ImageProviderType.GLIDE))
    }
  }
}
