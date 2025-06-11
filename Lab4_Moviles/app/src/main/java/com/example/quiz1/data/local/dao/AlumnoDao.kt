package com.example.quiz1.data.local.dao

// DAO providing CRUD operations for Alumno

import androidx.room.*
import com.example.quiz1.data.local.entity.AlumnoEntity

@Dao
interface AlumnoDao {
    @Query("SELECT * FROM alumno")
    suspend fun listar(): List<AlumnoEntity>

    @Query("SELECT * FROM alumno WHERE idAlumno = :id")
    suspend fun buscar(id: Int): AlumnoEntity?

    @Insert
    suspend fun insertar(alumno: AlumnoEntity)

    @Update
    suspend fun modificar(alumno: AlumnoEntity)

    @Delete
    suspend fun eliminar(alumno: AlumnoEntity)
}
