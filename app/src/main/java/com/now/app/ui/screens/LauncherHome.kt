package com.now.app.ui.screens

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

@Composable
fun LauncherHome(viewModel: LauncherViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp,40.dp,15.dp,30.dp)
    ) {
        NowTaskPanel("Task")
        Spacer(Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.End
            , verticalAlignment =  Alignment.Bottom
        ) {
            NowShortTermTaskPanel()
            Spacer(Modifier.width(10.dp))


        }
        Spacer(Modifier.height(10.dp))
        PomodoroClock()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFunction(){
    LauncherHome()
}