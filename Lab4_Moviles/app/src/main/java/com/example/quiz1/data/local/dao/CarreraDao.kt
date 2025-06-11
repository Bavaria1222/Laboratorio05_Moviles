package com.example.quiz1.data.local.dao

import androidx.room.*
import com.example.quiz1.data.local.entity.CarreraEntity

@Dao
interface CarreraDao {
    @Query("SELECT * FROM carrera")
    suspend fun listar(): List<CarreraEntity>

    @Query("SELECT * FROM carrera WHERE idCarrera = :id")
    suspend fun buscar(id: Int): CarreraEntity?

    @Insert
    suspend fun insertar(carrera: CarreraEntity)

    @Update
    suspend fun modificar(carrera: CarreraEntity)

    @Delete
    suspend fun eliminar(carrera: CarreraEntity)
}
