package com.example.asistenciaestudiante.data.repository

import android.content.Context
import com.example.asistenciaestudiante.Utils.NetworkUtils
import com.example.asistenciaestudiante.data.network.ApiService
import com.example.asistenciaestudiante.data.room.GroupDao
import com.example.asistenciaestudiante.data.room.GroupEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GroupRepository(
    private val apiService: ApiService,
    private val groupDao: GroupDao,
    private val context: Context
) {
    suspend fun getGroups(): List<GroupEntity> {
        return withContext(Dispatchers.IO) {
            if (NetworkUtils.isNetworkAvailable(context)) {
                try {
                    val response = apiService.getGroups()
                    if (response.isSuccessful) {
                        val groups = response.body()?.map { group ->
                            GroupEntity(name = group.name, id = group.id)
                        } ?: emptyList()
                        groupDao.insertGroups(groups) // Guardar en Room
                        groups
                    } else {
                        groupDao.getAllGroups() // Si falla la API, usar Room
                    }
                } catch (e: Exception) {
                    groupDao.getAllGroups() // Si hay un error, usar Room
                }
            } else {
                groupDao.getAllGroups() // Si no hay internet, usar Room
            }
        }
    }

    suspend fun saveGroups(groups: List<GroupEntity>) {
        withContext(Dispatchers.IO) {
            groupDao.insertGroups(groups)
        }
    }

    suspend fun clearGroups() {
        withContext(Dispatchers.IO) {
            groupDao.deleteAllGroups()
        }
    }
}


//package com.example.asistenciaestudiante.data.repository
//
//import android.content.Context
//import com.example.asistenciaestudiante.data.network.ApiService
//import com.example.asistenciaestudiante.data.network.RetrofitClient
//import com.example.asistenciaestudiante.data.room.GroupDao
//import com.example.asistenciaestudiante.data.room.GroupEntity
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//class GroupRepository(
//    private val apiService: ApiService,
//    private val groupDao: GroupDao,
//    private val context: Context
//) {
//
//    suspend fun getAllGroups(): List<GroupEntity> {
//        return withContext(Dispatchers.IO) {
//            val localGroups = groupDao.getAllGroups()
//            if (localGroups.isNotEmpty()) {
//                return@withContext localGroups
//            }
//            try {
//                val response = RetrofitClient.apiService.getGroups()
//                if (response.isSuccessful) {
//                    val remoteGroups = response.body() ?: emptyList()
//
//                    if (remoteGroups.isNotEmpty()) {
//                        val entities = remoteGroups.map { group ->
//                            GroupEntity(name = group.name, id = group.id)
//                        }
//                        groupDao.insertGroups(entities)
//                        return@withContext entities
//                    }
//                } else {
//                    println("Error en la respuesta: ${response.errorBody()?.string()}")
//                }
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//                return@withContext emptyList()
//            }
//            return@withContext emptyList()
//        }
//    }
//
//    suspend fun saveGroups(groups: List<GroupEntity>) {
//        withContext(Dispatchers.IO) {
//            groupDao.insertGroups(groups)
//        }
//    }
//
//    suspend fun clearGroups() {
//        withContext(Dispatchers.IO) {
//            groupDao.deleteAllGroups()
//        }
//    }
//}
