package com.schibsted.spain.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.schibsted.spain.fullscreenkallery.FullscreenGalleryActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launcherButton.setOnClickListener {
            val galleryIntent = Intent(this@MainActivity, FullscreenGalleryActivity::class.java)
            val imageUrlsList = ArrayList<String>()

            imageUrlsList.add(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/The_Simpsons_Logo.svg/2000px" + "-The_Simpsons_Logo.svg.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Homer/swsb_c" + "haracter_fact_homer_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Marge/swsb_c" + "haracter_fact_marge_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_bart_550x96" + "0.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Lisa/swsb_ch" + "aracter_fact_lisa_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Maggie/swsb_" + "character_fact_maggie_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_snowball_55" + "0x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_santaslittl" + "ehelper_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Krusty/swsb_" + "character_fact_krusty_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_sideshowmel" + "_550x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_krabappel_5" + "50x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_skinner_550" + "x960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_cletus_550x" + "960.png")
            imageUrlsList.add(
                    "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_brandine_55" + "0x960.png")
            imageUrlsList.add(
                    "http://vignette4.wikia.nocookie.net/lossimpson/images/c/c4/The_Simpsons_characters.png" + "/revision/20110629063200?path-prefix=es")

            galleryIntent.putStringArrayListExtra(FullscreenGalleryActivity.EXTRA_LIST_ITEMS,
                    imageUrlsList)

            startActivity(galleryIntent)
        }
    }
}
