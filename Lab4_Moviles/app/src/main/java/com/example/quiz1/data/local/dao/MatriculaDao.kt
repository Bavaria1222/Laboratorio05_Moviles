package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.MatriculaEntity

@Dao
interface MatriculaDao {
    @Query("SELECT * FROM matricula")
    suspend fun listar(): List<MatriculaEntity>

    @Query("SELECT * FROM matricula WHERE idMatricula = :id")
    suspend fun buscar(id: Int): MatriculaEntity?

    @Insert
    suspend fun insertar(matricula: MatriculaEntity)

    @Update
    suspend fun modificar(matricula: MatriculaEntity)

    @Delete
    suspend fun eliminar(matricula: MatriculaEntity)
}
