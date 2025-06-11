package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grupo")
data class GrupoEntity(
    @PrimaryKey val idGrupo: Int,
    val idCiclo: Int,
    val idCurso: Int,
    val numGrupo: Int,
    val horario: String,
    val idProfesor: String
)
