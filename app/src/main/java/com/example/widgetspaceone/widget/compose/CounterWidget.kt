package com.example.widgetspaceone.widget.compose

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.action
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle

class CounterWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            ValueCounter()
        }
    }

    @Composable
    private fun ValueCounter() {
        CounterContent(1f)
    }

    @Composable
    private fun CounterContent(value: Float) {
        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            var clickFirst by remember { mutableStateOf(0) }
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(3.dp),
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
                verticalAlignment = Alignment.Vertical.CenterVertically
            ) {
                Text(
                    text = "Counter",
                    style = TextStyle(
                        fontSize = TextUnit(12f, TextUnitType.Sp),
                        textAlign = TextAlign.Center
                    ),
                    modifier = GlanceModifier
                        .padding(3.dp)
                )
                Button(
                    text = clickFirst.toString(),
                    onClick = action { ++clickFirst },
                    modifier = GlanceModifier
                        .padding(3.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}