package com.example.asistenciaestudiante.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.asistenciaestudiante.data.model.Group
import com.example.asistenciaestudiante.viewModel.ListGroupsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListGroups(viewModel: ListGroupsViewModel = viewModel()) {
    val groups by viewModel.groups.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchGroups()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Selecciona un grupo") }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (groups.isEmpty()) {
                Text("Cargando grupos...", modifier = Modifier.padding(16.dp))
            } else {
                LazyColumn {
                    items(groups) { group ->
                        GroupItem(group)
                    }
                }
            }
        }
    }
}

@Composable
fun GroupItem(group: Group) {
    Text(
        text = group.name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* Aquí puedes navegar al grupo seleccionado */ }
    )
}

