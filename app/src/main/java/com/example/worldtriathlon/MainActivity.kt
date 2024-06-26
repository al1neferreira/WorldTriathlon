package com.example.worldtriathlon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.worldtriathlon.ui.AthletesListScreen
import com.example.worldtriathlon.ui.theme.WorldTriathlonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldTriathlonTheme {
                AthletesListScreen()
            }
        }
    }
}

