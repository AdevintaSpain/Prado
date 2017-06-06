Fullscreen image gallery for Android made in Kotlin!
====================================================

![Fullscreen image gallery demo](./art/fullscreen-gallery.gif)

Activity that launches a fullscreen gallery for your images.

## Installation

#### Prerequisites

minSdkVersion >= 15

#### Download

Just add the library dependency to you app's `build.gradle`:

```gradle
compile 'com.schibsted.android:TBD:1.0.0'
```

Ok, we've to publish the library before

## Features
- Creates a fullscreen gallery in a view pager way
- Shows the current image you are in and the total of images. The text to show is configurable.
- Adds support for zoom in, zoom out, scroll within the image, double-tap and so on
- All image resources are configurable

## Sample Usage
#### From Kotlin
Just start intent from extension `Context.kalleryIntent` passing by extra the list of image urls you want to load. That's it!

```kotlin
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
  
          launcherButton.setOnClickListener {
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
              startActivity(kalleryIntent(imageUrlsList))
          }
      }
```

#### From Java
TODO

## CHANGELOG
**1.0.0**
- Initial release!