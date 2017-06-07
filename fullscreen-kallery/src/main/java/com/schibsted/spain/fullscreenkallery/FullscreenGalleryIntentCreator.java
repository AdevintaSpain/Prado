package com.schibsted.spain.fullscreenkallery;

import android.content.Context;
import android.content.Intent;
import com.schibsted.spain.fullscreenkallery.extensions.ExtensionsKt;
import java.util.ArrayList;

public class FullscreenGalleryIntentCreator {

  public static Intent createGalleryIntent(Context context, ArrayList<String> imageUrls) {
    return ExtensionsKt.kalleryIntent(context, imageUrls);
  }
}
