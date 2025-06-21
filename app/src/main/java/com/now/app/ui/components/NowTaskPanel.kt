package com.now.app.ui.components
import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NowTaskPanel(
    taskTitle: String,
//    onClick: () -> Unit
) {
//    Surface(
////        modifier = Modifier
////            .fillMaxWidth()
//////            .clickable { onClick() },
////        ,
////        color = Color(0xFFCFEFFF),
////        shape = MaterialTheme.shapes.medium,
////        tonalElevation = 2.dp
//
//        modifier = Modifier
//            .fillMaxWidth()
//
//            .height(120.dp)
//            .clip(RoundedCornerShape(20.dp)).background(color = Color.White.copy(alpha = 0.3f))
//            .background(
//                Brush.verticalGradient(
//                    listOf(
//                        Color.White.copy(alpha = 0.3f),
//                        Color.White.copy(alpha = 0.15f)
//                    )
//                )
//            )
//            .blur(0.dp) // Apply blur to background layer
//            .padding(16.dp)
//    )
    GlassBox(modifier = Modifier.fillMaxWidth())
    {
        Column(modifier = Modifier
            .padding(16.dp) ) {
            Text(
                text = "Now Task",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = taskTitle,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun GlassBox(
    modifier: Modifier = Modifier,

    cornerRadius: Dp = 0.dp,
    contentPadding: Dp = 3.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(0))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFFFFF).copy(alpha = 0.25f),
                        Color(0xFFFFFFFF).copy(alpha = 0.05f),
                        Color(0xFFFFFFFF).copy(alpha = 0.0f),
                        Color(0xFFFFFFFF).copy(alpha = 0.1f),
                        Color(0xFFFFFFFF).copy(alpha = 0.3f)
                    )
                )
            )

            .blur(0.dp) // Frosted background effect
            .border(
                width = 0.25.dp,
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Gray.copy(alpha = 0.3f),
                        Color.Transparent,
                        Color.Gray.copy(alpha = 0.3f),
                    )
                ),
                shape = RoundedCornerShape(0.dp)
            )
        //            .padding(contentPadding)

    ) {
        content()
    }
}

