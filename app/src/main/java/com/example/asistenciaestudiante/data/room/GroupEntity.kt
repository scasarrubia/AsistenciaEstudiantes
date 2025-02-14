package com.example.asistenciaestudiante.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class GroupEntity(
    @PrimaryKey val id: String, // Podría ser el nombre del grado (ej: "703")
    val name: String // Nombre del grupo (puede ser igual al ID o tener más detalles)
)