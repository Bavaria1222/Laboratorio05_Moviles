package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.UsuarioEntity

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    suspend fun listar(): List<UsuarioEntity>

    @Query("SELECT * FROM usuario WHERE cedula = :cedula")
    suspend fun buscar(cedula: String): UsuarioEntity?

    @Insert
    suspend fun insertar(usuario: UsuarioEntity)

    @Update
    suspend fun modificar(usuario: UsuarioEntity)

    @Delete
    suspend fun eliminar(usuario: UsuarioEntity)
}
