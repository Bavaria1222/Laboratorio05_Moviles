package com.example.quiz1.data.local.entity

// Room entity for local persistence

// Room entity representing an Alumno

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumno")
data class AlumnoEntity(
    @PrimaryKey val idAlumno: Int,
    val nombre: String,
    val telefono: String,
    val email: String,
    val fechaNacimiento: String,
    val idCarrera: Int,
    val cedula: String
)
