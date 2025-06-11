package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profesor")
data class ProfesorEntity(
    @PrimaryKey val cedula: String,
    val nombre: String,
    val telefono: String,
    val email: String
)
