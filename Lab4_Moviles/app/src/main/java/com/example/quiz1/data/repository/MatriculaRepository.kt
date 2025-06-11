package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.MatriculaDao
import com.example.quiz1.data.local.entity.MatriculaEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MatriculaRepository(private val dao: MatriculaDao) {
    fun listar(): Flow<List<MatriculaEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(m: MatriculaEntity) = dao.insertar(m)
    suspend fun modificar(m: MatriculaEntity) = dao.modificar(m)
}
