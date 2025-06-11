package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "curso")
data class CursoEntity(
    @PrimaryKey val idCurso: Int,
    val codigo: String,
    val nombre: String,
    val creditos: Int,
    val horasSemanales: Int
)
