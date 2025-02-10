package com.example.gesto_livro.roomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AnotacoesLivroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLivro(livro: AnotarLivro)

    @Query("SELECT * FROM livros")
    fun getAllLivros(): Flow<List<AnotarLivro>>

    @Delete
    suspend fun deleteLivro(livro: AnotarLivro)
    @Update
    suspend fun updateLivro(livro: AnotarLivro)
}