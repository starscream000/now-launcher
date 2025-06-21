package com.now.app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.now.app.viewmodel.LauncherViewModel
import androidx.compose.ui.unit.dp
import com.now.app.ui.components.NowShortTermTaskPanel
import com.now.app.ui.components.NowTaskPanel
import com.now.app.ui.components.PomodoroClock
import com.now.app.ui.components.NowOrb
import android.app.WallpaperManager
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.background
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.rotationMatrix


@Composable
fun LauncherHome(viewModel: LauncherViewModel = viewModel()) {
    val context = LocalContext.current



    // Convert the drawable to a Compose painter


    // Layout: Show wallpaper as the background
    Box(
        modifier = Modifier
            .fillMaxSize()

            .background(
                Brush.radialGradient(

                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFF8CA1BD),
                        Color(0xFF7188A8)
                    ), center = Offset(850f,2400f),
                    radius= 2000f
                )
            )
            .padding(0.dp)
    ) {
        // Show the wallpaper if it exists


        // TODO: Place your Orb, Now Panel, App Tray here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp,40.dp,0.dp,30.dp)
        ) {
            NowTaskPanel("Task")
            Spacer(Modifier.height(1.dp))
            Row(
                horizontalArrangement = Arrangement.End
                , verticalAlignment =  Alignment.Bottom
            ) {
                NowShortTermTaskPanel()
                Spacer(Modifier.width(1.dp))


            }
            Spacer(Modifier.height(10.dp))
//        PomodoroClock()
            Spacer(Modifier.height(10.dp))
            NowOrb(onLogInputClick = {
                // Handle log input click here, e.g., navigate to log input screen
            })
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun PreviewFunction(){
    LauncherHome()
}

