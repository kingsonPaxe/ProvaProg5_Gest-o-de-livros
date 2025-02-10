package com.example.gesto_livro.consumindoAPI

data class LivrosResponse(
    val codigo: String,
    val mensagem: String,
    var data: ArrayList<Livros>
)
