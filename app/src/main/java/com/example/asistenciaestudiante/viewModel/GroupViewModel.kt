package com.example.asistenciaestudiante.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.asistenciaestudiante.data.network.RetrofitClient
import com.example.asistenciaestudiante.data.repository.GroupRepository
import com.example.asistenciaestudiante.data.room.AppDatabase
import com.example.asistenciaestudiante.data.room.GroupEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GroupViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GroupRepository
    private val _groups = MutableStateFlow<List<GroupEntity>>(emptyList())
    val groups: StateFlow<List<GroupEntity>> = _groups

    init {
        val db = AppDatabase.getDatabase(application)
        val apiService = RetrofitClient.apiService
        repository = GroupRepository(apiService, db.groupDao(), application)
        loadGroups()
    }

    fun loadGroups() {
        viewModelScope.launch {
            val groupsFromRepo = repository.getGroups()
            if (groupsFromRepo.isEmpty()) {
                println("⚠️ No hay grupos guardados en Room.")
            } else {
                println("✅ Grupos recuperados de Room: $groupsFromRepo")
            }
            _groups.value = groupsFromRepo
        }
    }

//    fun loadGroups() {
//        viewModelScope.launch {
//            _groups.value = repository.getGroups()
//        }
//    }
}
