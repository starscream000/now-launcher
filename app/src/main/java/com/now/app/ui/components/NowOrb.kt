package com.now.app.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun NowOrb(
    modifier: Modifier = Modifier,
    onLogInputClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Radial/vertical menu options
        if (expanded) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(bottom = 80.dp)
                    .alpha(0.9f)
            ) {
                OptionButton("Log Input", onClick = {
                    onLogInputClick()
//                    expanded = false
                })
                OptionButton("Another Option", onClick = {
                    // Another action
//                    expanded = false
                })
            }
        }

        // The Orb itself
        Box(
            modifier = Modifier
                .size(70.dp)
//                .shadow(20.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.2f),
                            Color.Black.copy(alpha = 0.1f)

                        ),
                        center = Offset(100f,100f),
                        radius = 90f
                    ),
                    shape = CircleShape
                )
                .clickable { expanded = !expanded;
                           println(expanded);},
            contentAlignment = Alignment.Center
        ) {

        }
    }
}

@Composable
fun OptionButton(
    label: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = Color.Blue.copy(alpha = 0.2f),
                shape = RoundedCornerShape(50)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.Red,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
