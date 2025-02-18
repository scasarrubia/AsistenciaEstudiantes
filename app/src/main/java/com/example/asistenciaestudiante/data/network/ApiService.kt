package com.example.asistenciaestudiante.data.network

import com.example.asistenciaestudiante.data.model.Group
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("exec")
    suspend fun getGroups(
        @Query("accion") accion: String = "obtenerGrupos"
    ): Response<List<Group>>

    @GET("exec")
    suspend fun getStudents(
        @Query("accion") accion: String = "obtenerEstudiantes",
        @Query("idGrupo") idGrupo: String
    ): Response<List<Student>>
}
