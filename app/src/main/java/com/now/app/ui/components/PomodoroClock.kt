package com.now.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.now.app.viewmodel.PomodoroViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PomodoroClock(viewModel: PomodoroViewModel = viewModel()) {
    val timeLeft by viewModel.timeLeft.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    val minutes = timeLeft / 60
    val seconds = timeLeft % 60

    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)
            .background(Color(0xFFD32F2F), RoundedCornerShape(12.dp)) // Red tone
            .padding(20.dp)
    ) {
        Column {
            Text(
                text = "Pomodoro Timer",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = String.format("%02d:%02d", minutes, seconds),
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.toggleTimer() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(if (isRunning) "Pause" else "Start", color = Color.Red)
                }

                Button(
                    onClick = { viewModel.resetTimer() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Reset", color = Color.Red)
                }
            }
        }
    }
}