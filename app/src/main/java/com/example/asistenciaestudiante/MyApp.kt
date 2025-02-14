package com.example.asistenciaestudiante

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
fun MyApp(content: @Composable () -> Unit){
    MaterialTheme{
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}