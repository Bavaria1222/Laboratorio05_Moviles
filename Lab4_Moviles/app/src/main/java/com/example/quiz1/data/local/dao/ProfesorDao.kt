package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.ProfesorEntity

@Dao
interface ProfesorDao {
    @Query("SELECT * FROM profesor")
    suspend fun listar(): List<ProfesorEntity>

    @Query("SELECT * FROM profesor WHERE cedula = :cedula")
    suspend fun buscar(cedula: String): ProfesorEntity?

    @Insert
    suspend fun insertar(profesor: ProfesorEntity)

    @Update
    suspend fun modificar(profesor: ProfesorEntity)

    @Delete
    suspend fun eliminar(profesor: ProfesorEntity)
}
