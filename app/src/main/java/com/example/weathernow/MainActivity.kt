package com.example.weathernow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.weathernow.ui.theme.WViewModel
import com.example.weathernow.ui.theme.WeatherPage
import com.example.weathernow.ui.theme.WeathernowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val wViewModel = ViewModelProvider(this)[WViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            WeathernowTheme {


                WeatherPage(wViewModel)
                }
            }
        }
    }
