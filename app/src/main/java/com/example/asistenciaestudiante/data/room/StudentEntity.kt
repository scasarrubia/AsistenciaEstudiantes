package com.example.asistenciaestudiante.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey val id: String,  // ID del estudiante
    val name: String,            // Nombre
    val lastName: String,        // Apellido
    val groupId: String          // ID del grupo al que pertenece
)
