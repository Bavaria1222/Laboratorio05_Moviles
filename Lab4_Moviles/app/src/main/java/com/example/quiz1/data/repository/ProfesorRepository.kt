package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.ProfesorDao
import com.example.quiz1.data.local.entity.ProfesorEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfesorRepository(private val dao: ProfesorDao) {
    fun listar(): Flow<List<ProfesorEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(profesor: ProfesorEntity) = dao.insertar(profesor)
    suspend fun modificar(profesor: ProfesorEntity) = dao.modificar(profesor)
    suspend fun eliminar(profesor: ProfesorEntity) = dao.eliminar(profesor)
}
