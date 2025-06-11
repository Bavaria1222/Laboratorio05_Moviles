package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan_estudio")
data class PlanEstudioEntity(
    @PrimaryKey val idPlanEstudio: Int,
    val idCarrera: Int,
    val idCurso: Int,
    val anio: Int,
    val ciclo: Int
)
