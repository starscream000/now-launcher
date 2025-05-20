package com.now.app.intents
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast

object AppLauncher {
    fun launchApp(context: Context, packageName: String) {
        val pm = context.packageManager
        val intent = pm.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Cannot launch app", Toast.LENGTH_SHORT).show()
        }
    }
}