package com.example.asistenciaestudiante.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.asistenciaestudiante.data.model.Group
import com.example.asistenciaestudiante.data.network.RetrofitClient
import com.example.asistenciaestudiante.data.repository.GroupRepository
import com.example.asistenciaestudiante.data.room.AppDatabase
import com.example.asistenciaestudiante.data.room.GroupEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListGroupsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: GroupRepository
    private val _groups = MutableStateFlow<List<Group>>(emptyList())
    val groups: StateFlow<List<Group>> = _groups

    init {
        val db = AppDatabase.getDatabase(application)
        val apiService = RetrofitClient.apiService
        repository = GroupRepository(apiService, db.groupDao(), application) // Ahora tiene los 3 parámetros
        fetchGroups()
    }


    fun fetchGroups() {
        viewModelScope.launch {
            val groupEntities: List<GroupEntity> = repository.getGroups() // Intenta con API o Room
            _groups.value = groupEntities.map { Group(it.id, it.name) } // Convierte a modelo UI
        }
    }
}
