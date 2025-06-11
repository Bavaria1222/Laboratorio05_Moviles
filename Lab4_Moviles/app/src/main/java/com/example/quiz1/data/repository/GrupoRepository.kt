package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.GrupoDao
import com.example.quiz1.data.local.entity.GrupoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GrupoRepository(private val dao: GrupoDao) {
    fun listar(): Flow<List<GrupoEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(grupo: GrupoEntity) = dao.insertar(grupo)
    suspend fun modificar(grupo: GrupoEntity) = dao.modificar(grupo)
    suspend fun eliminar(grupo: GrupoEntity) = dao.eliminar(grupo)
}
