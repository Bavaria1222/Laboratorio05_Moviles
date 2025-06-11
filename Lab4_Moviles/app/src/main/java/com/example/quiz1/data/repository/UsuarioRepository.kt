package com.example.quiz1.data.repository

import com.example.quiz1.data.local.dao.UsuarioDao
import com.example.quiz1.data.local.entity.UsuarioEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsuarioRepository(private val dao: UsuarioDao) {
    fun listar(): Flow<List<UsuarioEntity>> = flow { emit(dao.listar()) }

    suspend fun buscar(cedula: String): UsuarioEntity? = dao.buscar(cedula)

    suspend fun insertar(u: UsuarioEntity) = dao.insertar(u)

    suspend fun modificar(u: UsuarioEntity) = dao.modificar(u)

    suspend fun eliminar(u: UsuarioEntity) = dao.eliminar(u)

    suspend fun loginLocal(cedula: String, clave: String): UsuarioEntity? {
        val usuario = dao.buscar(cedula)
        return if (usuario != null && usuario.clave == clave) usuario else null
    }
}
