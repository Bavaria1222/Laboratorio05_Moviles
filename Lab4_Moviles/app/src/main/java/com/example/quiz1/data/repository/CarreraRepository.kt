package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.CarreraDao
import com.example.quiz1.data.local.entity.CarreraEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CarreraRepository(private val dao: CarreraDao) {
    fun listar(): Flow<List<CarreraEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(carrera: CarreraEntity) = dao.insertar(carrera)
    suspend fun modificar(carrera: CarreraEntity) = dao.modificar(carrera)
    suspend fun eliminar(carrera: CarreraEntity) = dao.eliminar(carrera)
}
