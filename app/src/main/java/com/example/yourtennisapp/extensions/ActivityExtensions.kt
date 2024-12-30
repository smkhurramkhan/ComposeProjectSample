package com.example.yourtennisapp.extensions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun Activity.startActivity(
    targetActivity: Class<*>,
    finishActivity: Boolean = false,
    extras: Intent.() -> Unit = {}
) {
    val intent = Intent(this, targetActivity)
    intent.extras()
    startActivity(intent)
    if (finishActivity) {
        finish()
    }
}

fun Context.isNotificationListenerEnabled(): Boolean {
    val enabledNotificationListeners = Settings.Secure.getString(
        contentResolver,
        "enabled_notification_listeners"
    )
    return !enabledNotificationListeners.isNullOrEmpty() && enabledNotificationListeners.contains(
        packageName
    )
}

fun Context.getStoragePermissions(): Array<String> {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_VIDEO,
            Manifest.permission.READ_MEDIA_AUDIO
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }
}

fun Context.getNotificationPermission(): Array<String> {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(Manifest.permission.POST_NOTIFICATIONS)
    } else {
        emptyArray() // No permissions required for versions below Android 13
    }
}

fun Context.showShortToast(textRes: Int) {
    showShortToast(getString(textRes))
}

fun Context.showShortToast(text: String?) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun View.applySystemWindowInsetsAsPadding() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}

fun AppCompatActivity.setSupportActionBar(
    toolbar: Toolbar?,
    displayHomeAsUpEnabled: Boolean,
    displayShowTitleEnabled: Boolean
) {
    setSupportActionBar(toolbar)
    supportActionBar?.let {
        it.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled)
        it.setDisplayShowTitleEnabled(displayShowTitleEnabled)
    }
}