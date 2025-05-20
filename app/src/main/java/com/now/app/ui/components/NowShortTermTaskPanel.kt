package com.now.app.ui.components

import android.content.Context
import android.util.Log
import android.widget.ListView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NowShortTermTaskPanel (){
    Surface (
        Modifier.width(230.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp){

        val items = listOf(
            Pair("Item 1", "6:30 pm"),
            Pair("Item 2", "6:30 pm"),
            Pair("Item 3", "6:30 pm"),
            Pair("Item 4", "6:30 pm"),
            Pair("Item 5", "6:30 pm")
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Short Term Tasks",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            items.forEach { (title, value) ->
                ListItemCard(title = title, value = value)
            }



        }
    }

}

@Composable
fun ListItemCard(title: String, value: String) {
//    Card(
//        modifier = Modifier.fillMaxWidth()
//            .padding(vertical = 8.dp)
//    )

        Row(
            modifier = Modifier.padding(vertical = 8.dp)
                .width(400.dp)
                .clickable(onClick = {
                    Log.println( Log.ASSERT,"STL", "$title-$value")}),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium
            )
        }

}