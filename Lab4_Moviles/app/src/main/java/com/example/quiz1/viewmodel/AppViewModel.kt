package com.example.quiz1.viewmodel

// ViewModel exposing simple flows for Room data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz1.data.local.db.AppDatabase
import com.example.quiz1.data.local.entity.AlumnoEntity
import com.example.quiz1.data.local.entity.MatriculaEntity
import com.example.quiz1.data.repository.AlumnoRepository
import com.example.quiz1.data.repository.MatriculaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// Example ViewModel showing how to use the Room repositories
class AppViewModel(app: Application) : AndroidViewModel(app) {
    private val db = AppDatabase.getDatabase(app)
    private val alumnoRepo = AlumnoRepository(db.alumnoDao())
    private val matriculaRepo = MatriculaRepository(db.matriculaDao())

    val alumnos: Flow<List<AlumnoEntity>> = alumnoRepo.listar()

    fun insertarAlumno(alumno: AlumnoEntity) {
        viewModelScope.launch { alumnoRepo.insertar(alumno) }
    }

    fun actualizarMatricula(m: MatriculaEntity) {
        viewModelScope.launch { matriculaRepo.modificar(m) }
    }
}
