package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.GrupoEntity

@Dao
interface GrupoDao {
    @Query("SELECT * FROM grupo")
    suspend fun listar(): List<GrupoEntity>

    @Query("SELECT * FROM grupo WHERE idGrupo = :id")
    suspend fun buscar(id: Int): GrupoEntity?

    @Insert
    suspend fun insertar(grupo: GrupoEntity)

    @Update
    suspend fun modificar(grupo: GrupoEntity)

    @Delete
    suspend fun eliminar(grupo: GrupoEntity)
}
