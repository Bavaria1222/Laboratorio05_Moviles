package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.UsuarioDao
import com.example.quiz1.data.local.entity.UsuarioEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsuarioRepository(private val dao: UsuarioDao) {
    fun listar(): Flow<List<UsuarioEntity>> = flow { emit(dao.listar()) }
    suspend fun buscar(cedula: String) = dao.buscar(cedula)
    suspend fun insertar(u: UsuarioEntity) = dao.insertar(u)
}
