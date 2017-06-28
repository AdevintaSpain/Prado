# Prado
**Your images, your museum**

![Fullscreen image gallery demo](./art/fullscreen-gallery.gif)

Showcase your images like if they were in the Prado museum!

## Installation

#### Prerequisites

minSdkVersion >= 15

#### Download

Just add the library dependency to you app's `build.gradle`:

```gradle
compile 'com.schibsted.spain:prado:1.0.0'
```

## Features
- Shows your images in a fancy way, fullscreen
- Go through images by swiping them
- Shows the current image you are in and the total of images
- Allows device rotation
- Adds support for zoom in, zoom out, scroll within the image and double-tap
- TECH: Support for loading images with Picasso or Glide, choose your favorite!

## Sample Usage
#### From Kotlin
Build the intent you should start from extension `Context.buildPradoGalleryIntent` passing by extra the list of image urls you want to load. That's it!

```kotlin
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
```

#### From Java
```java
  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
  
      final List<String> imageUrlsList = new ArrayList<>();
  
      imageUrlsList.add(
          "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/The_Simpsons_Logo.svg/2000px-The_Simpsons_Logo.svg.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Homer/swsb_character_fact_homer_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Marge/swsb_character_fact_marge_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_bart_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Lisa/swsb_character_fact_lisa_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Maggie/swsb_character_fact_maggie_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_snowball_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_santaslittlehelper_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/simpsons-character/Krusty/swsb_character_fact_krusty_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_sideshowmel_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_krabappel_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_skinner_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_cletus_550x960.png");
      imageUrlsList.add(
          "http://assets.fxnetworks.com/shows/the-simpsons/photos/swsb_character_fact_brandine_550x960.png");
      imageUrlsList.add(
          "http://vignette4.wikia.nocookie.net/lossimpson/images/c/c4/The_Simpsons_characters.png/revision/20110629063200?path-prefix=es");
      imageUrlsList.add("");
  
      Button launcherPicassoButton = (Button) findViewById(R.id.launcherPicassoButton);
      launcherPicassoButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          startActivity(PradoGalleryActivity.buildPradoGalleryIntent(MainActivity.this, imageUrlsList));
        }
      });
  
      Button launcherGlideButton = (Button) findViewById(R.id.launcherGlideButton);
      launcherGlideButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          startActivity(PradoGalleryActivity.buildPradoGalleryIntent(MainActivity.this, imageUrlsList,
              ImageProvider.ImageProviderType.GLIDE));
        }
      });
```

## Open source libraries we use
- [Picasso](https://github.com/square/picasso)
- [Glide](https://github.com/bumptech/glide)
- [PhotoView](https://github.com/chrisbanes/PhotoView)
- [OkHttp](https://github.com/square/okhttp)
- [RecyclerViewSnap](https://github.com/rubensousa/RecyclerViewSnap)
- [Barista](https://github.com/SchibstedSpain/Barista)

## CHANGELOG
**1.0.0**
- Initial release!

## License

```
Copyright 2017 Schibsted Classified Media Spain S.L.


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```