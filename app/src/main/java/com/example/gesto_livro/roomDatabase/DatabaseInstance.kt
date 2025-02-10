package com.example.gesto_livro.roomDatabase

import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    private var INSTANCE: LivroDatabase? = null

    fun getDatabase(context: Context): LivroDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                LivroDatabase::class.java,
                "Gestpr de Livros"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
