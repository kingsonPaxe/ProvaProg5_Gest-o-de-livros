package com.example.gesto_livro.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gesto_livro.roomDatabase.AnotarLivro

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TelaInicialViewModel @Inject constructor(
    private val dao: com.example.gesto_livro.roomDatabase.AnotacoesLivroDao
) : ViewModel() {

    val anotacoes = dao.getAllLivros()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )

    fun deletarLivro(anotarLivro: AnotarLivro){
        viewModelScope.launch {
            dao.deleteLivro(anotarLivro)
        }
    }

    fun atualizarLivro(anotarLivro: AnotarLivro) {
        viewModelScope.launch {
            dao.updateLivro(anotarLivro)
        }
    }
}
