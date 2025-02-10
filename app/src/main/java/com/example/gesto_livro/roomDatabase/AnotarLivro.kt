package com.example.gesto_livro.roomDatabase
import androidx.room.PrimaryKey
import androidx.room.Entity


@Entity(tableName = "livros")
data class AnotarLivro (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String?=null,
    val autor: String?=null,
    val ano: String?=null,
)