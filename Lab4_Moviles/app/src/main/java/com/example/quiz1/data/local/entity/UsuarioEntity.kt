package com.example.quiz1.data.local.entity

// Room entity for local persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey val cedula: String,
    val clave: String,
    val rol: String
)
