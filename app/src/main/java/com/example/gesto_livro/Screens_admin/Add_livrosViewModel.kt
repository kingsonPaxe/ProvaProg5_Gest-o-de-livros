package com.example.gesto_livro.Screens_admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gesto_livro.roomDatabase.AnotacoesLivroDao
import com.example.gesto_livro.roomDatabase.AnotarLivro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Add_livrosViewModel @Inject constructor(
    private val dao: AnotacoesLivroDao
) : ViewModel() {

    fun salvarAnotacao(titulo: String, autor: String, ano: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val adicionarLivro = AnotarLivro(
                titulo = titulo,
                autor = autor,
                ano = ano,
            )
            dao.addLivro(adicionarLivro)
        }
    }

    fun atualizarAnotacao(livro: AnotarLivro) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.updateLivro(livro)
        }
    }
}
