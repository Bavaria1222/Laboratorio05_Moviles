package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.PlanEstudioEntity

@Dao
interface PlanEstudioDao {
    @Query("SELECT * FROM plan_estudio")
    suspend fun listar(): List<PlanEstudioEntity>

    @Query("SELECT * FROM plan_estudio WHERE idPlanEstudio = :id")
    suspend fun buscar(id: Int): PlanEstudioEntity?

    @Insert
    suspend fun insertar(planEstudio: PlanEstudioEntity)

    @Update
    suspend fun modificar(planEstudio: PlanEstudioEntity)

    @Delete
    suspend fun eliminar(planEstudio: PlanEstudioEntity)
}
