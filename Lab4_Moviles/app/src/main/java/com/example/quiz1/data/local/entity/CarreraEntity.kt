package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carrera")
data class CarreraEntity(
    @PrimaryKey val idCarrera: Int,
    val codigo: String,
    val nombre: String,
    val titulo: String
)
