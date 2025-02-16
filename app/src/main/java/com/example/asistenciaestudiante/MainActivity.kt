package com.example.asistenciaestudiante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.asistenciaestudiante.ui.theme.AsistenciaEstudianteTheme
import com.example.asistenciaestudiante.views.ListGroups

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AsistenciaEstudianteTheme {
                MyApp {
                    ListGroups()
                }
            }
        }
    }
}