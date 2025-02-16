package com.example.asistenciaestudiante.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _groups = MutableLiveData<List<Group>>(emptyList())
    val groups: LiveData<List<Group>> get() = _groups

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        val db = AppDatabase.getDatabase(application)
        val apiService = RetrofitClient.apiService
        repository = GroupRepository(apiService, db.groupDao(), application) // Ahora tiene los 3 parámetros
        fetchGroups()
    }


    fun fetchGroups() {
        _loading.value = true
        viewModelScope.launch {
            try {
                val groupEntities: List<GroupEntity> = repository.getGroups()
                _groups.value = groupEntities.map { Group(it.id, it.name) }
                _error.value = null
            }catch (e: Exception){
                _error.value = "Error fetchGroups"
            } finally {
                _loading.value = false
            }
            // Convierte a modelo UI
        }
    }
}
