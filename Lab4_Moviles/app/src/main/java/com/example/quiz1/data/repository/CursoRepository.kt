package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.CursoDao
import com.example.quiz1.data.local.entity.CursoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CursoRepository(private val dao: CursoDao) {
    fun listar(): Flow<List<CursoEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(curso: CursoEntity) = dao.insertar(curso)
    suspend fun modificar(curso: CursoEntity) = dao.modificar(curso)
    suspend fun eliminar(curso: CursoEntity) = dao.eliminar(curso)
}
