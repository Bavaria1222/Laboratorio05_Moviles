package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.PlanEstudioDao
import com.example.quiz1.data.local.entity.PlanEstudioEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlanEstudioRepository(private val dao: PlanEstudioDao) {
    fun listar(): Flow<List<PlanEstudioEntity>> = flow { emit(dao.listar()) }
    suspend fun insertar(plan: PlanEstudioEntity) = dao.insertar(plan)
    suspend fun modificar(plan: PlanEstudioEntity) = dao.modificar(plan)
    suspend fun eliminar(plan: PlanEstudioEntity) = dao.eliminar(plan)
}
