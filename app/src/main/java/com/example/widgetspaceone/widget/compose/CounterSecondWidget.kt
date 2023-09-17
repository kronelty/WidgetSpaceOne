package com.example.widgetspaceone.widget.compose

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
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
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.Text

class CounterSecondWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            ValueCounter()
        }
    }

    @Composable
    private fun ValueCounter() {
        Column {
            CounterContent(1f)
        }
    }

    @Composable
    private fun CounterContent(value: Float) {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(Color.Magenta)
                .padding(12.dp),
            verticalAlignment = Alignment.Vertical.CenterVertically,
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
        ) {
            var clickFirst by remember { mutableStateOf(0) }
            var clickSecond by remember { mutableStateOf(0) }

            Text(
                text = "remember value",
                modifier = GlanceModifier.padding(12.dp)
            )
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally
            ) {
                Button(
                    modifier = GlanceModifier.defaultWeight(),
                    text = clickFirst.toString(),
                    onClick = action { ++clickFirst },
                )
                Spacer(modifier = GlanceModifier.width(6.dp))
                Button(
                    modifier = GlanceModifier.defaultWeight(),
                    text = clickSecond.toString(),
                    onClick = action { ++clickSecond },
                )
            }
        }
    }
}