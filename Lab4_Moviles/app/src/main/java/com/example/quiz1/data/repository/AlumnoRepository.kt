package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.AlumnoDao
import com.example.quiz1.data.local.entity.AlumnoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlumnoRepository(private val dao: AlumnoDao) {
    fun listar(): Flow<List<AlumnoEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(alumno: AlumnoEntity) = dao.insertar(alumno)
    suspend fun modificar(alumno: AlumnoEntity) = dao.modificar(alumno)
    suspend fun eliminar(alumno: AlumnoEntity) = dao.eliminar(alumno)
}
