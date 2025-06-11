package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matricula")
data class MatriculaEntity(
    @PrimaryKey val idMatricula: Int,
    val cedulaAlumno: String,
    val idGrupo: Int,
    val nota: Float?
)
