package com.example.gesto_livro.Screens_admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gesto_livro.viewModel.TelaInicialViewModel
import com.example.gesto_livro.itemlista.AnotacoesItem
import com.example.gesto_livro.ui.theme.ShapeEditText
import com.example.gesto_livro.ui.theme.ShapeFloatingActionButton

@Composable
fun Tela_inicial(
    viewModel: TelaInicialViewModel = hiltViewModel(),
    adicionarLivro: () ->Unit
){
    var livros by remember{ mutableStateOf("") }
    var livrosadd = viewModel.anotacoes.collectAsStateWithLifecycle().value
    Scaffold (
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {adicionarLivro()}, // Vai para tela de adiconar livros
                containerColor = Color.Blue,
                contentColor = Color.White,
                shape = ShapeFloatingActionButton.large
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value=livros,
                    onValueChange = {
                        livros = it
                    },
                    label = { Text("Procurar livro... ") },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    shape = ShapeEditText.small,

                )

                IconButton(
                    onClick = {},
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Procurar livro" )
                }
            }

//            val livroList: MutableList<AnotarLivro> = mutableListOf(
//                AnotarLivro(
//                    titulo = "O mundo meu",
//                    autor = "Jeovani Paxe",
//                    ano = "20304",
//                    id = 1,
//                    description = "545565"
//                ),
//
//                AnotarLivro(
//                    titulo = "O Angolano",
//                    autor = " Paxe",
//                    ano = "2013",
//                    id = 2,
//                    description = "Descricao1"
//                ),
//
//                AnotarLivro(
//                    titulo = "Pensador",
//                    autor = " Augusto cury",
//                    ano = "2012",
//                    id = 3,
//                    description = "Descricao2"
//                )
//            )

            // Adicionando Instens

            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            )  {
                items(livrosadd){livro ->
                    AnotacoesItem(
                        anotarLivro = livro,
                        eliminar = { viewModel.deletarLivro(it) }
                    )
                }
            }
        }
    }


}
