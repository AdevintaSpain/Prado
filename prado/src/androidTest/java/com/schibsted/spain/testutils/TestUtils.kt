package com.schibsted.spain.testutils

import android.app.Activity
import android.view.WindowManager
import android.os.Build
import android.provider.Settings
import android.support.test.InstrumentationRegistry


class TestUtils {

  companion object {
    fun unlockScreen(activity: Activity) {
      activity.runOnUiThread {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
            or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
            or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
      }
    }

    fun disableAnimationsOnTravis(activity: Activity) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        Settings.Global.putFloat(activity.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 0f)
      }
    }

    fun grantWriteSecureSettingsPermission() {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "pm grant " + InstrumentationRegistry.getInstrumentation().targetContext.packageName
                + " android.permission.WRITE_SECURE_SETTINGS")
      }
    }
  }
}