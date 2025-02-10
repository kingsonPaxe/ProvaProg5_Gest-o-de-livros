package com.example.gesto_livro.roomDatabase

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AnotarLivro::class], version = 1, exportSchema = false)
abstract class LivroDatabase: RoomDatabase() {

    abstract fun anotacoesLivroDao(): AnotacoesLivroDao

    companion object {
        @Volatile
        private var instance: LivroDatabase? = null

        fun getDatabase(context: Context): LivroDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    LivroDatabase::class.java,
                    "livro_db"
                ).build()
                    .also {
                        instance = it
                    }
            }
        }
    }
}