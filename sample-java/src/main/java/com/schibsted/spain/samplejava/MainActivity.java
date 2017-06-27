package com.schibsted.spain.samplejava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.schibsted.spain.prado.PradoGalleryActivity;
import com.schibsted.spain.prado.imageprovider.ImageProvider;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
  }
}
