package com.example.quiz1.data.local.db

// Singleton Room database used across the app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quiz1.data.local.dao.*
import com.example.quiz1.data.local.entity.*

// Room database holding all academic entities
@Database(
    entities = [AlumnoEntity::class, CarreraEntity::class, ProfesorEntity::class,
        CursoEntity::class, GrupoEntity::class, MatriculaEntity::class,
        PlanEstudioEntity::class, UsuarioEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alumnoDao(): AlumnoDao
    abstract fun carreraDao(): CarreraDao
    abstract fun profesorDao(): ProfesorDao
    abstract fun cursoDao(): CursoDao
    abstract fun grupoDao(): GrupoDao
    abstract fun matriculaDao(): MatriculaDao
    abstract fun planEstudioDao(): PlanEstudioDao
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gestion_academica.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
