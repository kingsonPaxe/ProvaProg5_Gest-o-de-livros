package com.example.gesto_livro.consumindoAPI

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LivrosViewModel:ViewModel() {
    var listaLivros: ArrayList<Livros> by mutableStateOf(arrayListOf())

    fun getLivros(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.getLivros()
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    listaLivros = response.body()!!.data
                }
            }
        }
    }

    fun addLivros(Dados: Livros){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.addLivros(Dados)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getLivros()
                }
            }
        }
    }

    fun updateLivros(id_livros:String, Dados: Livros){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.updateLivros(id_livros,Dados)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getLivros()
                }
            }
        }
    }

    fun deleteLivros(id_livros:String){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.deleteLivros(id_livros)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getLivros()
                }
            }
        }
    }
}