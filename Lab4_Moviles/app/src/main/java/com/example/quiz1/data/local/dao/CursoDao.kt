package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.CursoEntity

@Dao
interface CursoDao {
    @Query("SELECT * FROM curso")
    suspend fun listar(): List<CursoEntity>

    @Query("SELECT * FROM curso WHERE idCurso = :id")
    suspend fun buscar(id: Int): CursoEntity?

    @Insert
    suspend fun insertar(curso: CursoEntity)

    @Update
    suspend fun modificar(curso: CursoEntity)

    @Delete
    suspend fun eliminar(curso: CursoEntity)
}
