# Prado
**Your images, your art galley**

<img src="art/prado.gif" alt="Prado demo" width="320" height="553">

Showcase your images like if they were in the Prado museum!

## Installation

#### Prerequisites

minSdkVersion >= 15

#### Download

Just add the library dependency to your app's `build.gradle`:

```gradle
compile 'com.schibsted.spain:prado:1.0.0'
```

## Features
- Shows your images in a fancy way fullscreen way
- Go through images by swiping
- Shows the current image position and the total of images
- Allows device rotation
- Adds support for zoom in, zoom out, scroll within the image and double-tap
- TECH: Support for loading images with Picasso or Glide, choose your favorite!

## Sample Usage
#### From Kotlin
Create the intent from the extension `Context.buildPradoGalleryIntent` including the list of image urls as extra and start it. That's all!

```kotlin
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
      
          val imageUrlsList = arrayListOf(
              "https://upload.wikimedia.org/wikipedia/commons/3/3f/Francisco_de_Goya_y_Lucientes_-_Los_fusilamientos_del_tres_de_mayo_-_1814.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/9/99/Las_Meninas_01.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/f/f1/El_caballero_de_la_mano_en_el_pecho.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/6/62/The_Garden_of_Earthly_Delights_by_Bosch_High_Resolution_2.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/f/fb/La_Anunciaci%C3%B3n_%28Fra_Angelico-Prado%29.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Carlos_V_en_M%C3%BChlberg%2C_by_Titian%2C_from_Prado_in_Google_Earth.jpg/3000px-Carlos_V_en_M%C3%BChlberg%2C_by_Titian%2C_from_Prado_in_Google_Earth.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/b/bb/Rembrandt_Harmensz._van_Rijn_014.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/b/b2/Peter_Paul_Rubens_-_The_Three_Graces%2C_1635.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/1/16/Raffael_048.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/d/d4/Crucifixi%C3%B3n_Juan_de_Flandes.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/d/da/Albrecht_D%C3%BCrer_103.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/1/1a/Weyden_Deposition.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/b/b6/El_sue%C3%B1o_de_Jacob%2C_por_Jos%C3%A9_de_Ribera.jpg",
              "https://upload.wikimedia.org/wikipedia/commons/8/8b/Giovanni_Battista_Tiepolo_022.jpg",
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
              "https://upload.wikimedia.org/wikipedia/commons/3/3f/Francisco_de_Goya_y_Lucientes_-_Los_fusilamientos_del_tres_de_mayo_-_1814.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/9/99/Las_Meninas_01.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/f/f1/El_caballero_de_la_mano_en_el_pecho.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/6/62/The_Garden_of_Earthly_Delights_by_Bosch_High_Resolution_2.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/f/fb/La_Anunciaci%C3%B3n_%28Fra_Angelico-Prado%29.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Carlos_V_en_M%C3%BChlberg%2C_by_Titian%2C_from_Prado_in_Google_Earth.jpg/3000px-Carlos_V_en_M%C3%BChlberg%2C_by_Titian%2C_from_Prado_in_Google_Earth.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/b/bb/Rembrandt_Harmensz._van_Rijn_014.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/b/b2/Peter_Paul_Rubens_-_The_Three_Graces%2C_1635.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/1/16/Raffael_048.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/d/d4/Crucifixi%C3%B3n_Juan_de_Flandes.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/d/da/Albrecht_D%C3%BCrer_103.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/1/1a/Weyden_Deposition.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/b/b6/El_sue%C3%B1o_de_Jacob%2C_por_Jos%C3%A9_de_Ribera.jpg");
      imageUrlsList.add(
              "https://upload.wikimedia.org/wikipedia/commons/8/8b/Giovanni_Battista_Tiepolo_022.jpg");
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