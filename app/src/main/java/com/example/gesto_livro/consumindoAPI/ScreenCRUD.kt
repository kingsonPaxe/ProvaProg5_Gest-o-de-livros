//package com.example.gesto_livro.consumindoAPI
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun ScreanCRUD(listaLivros: ArrayList<Livros>, viewModel: LivrosViewModel){
//    var id by remember { mutableStateOf("") }
//    var titulo by remember { mutableStateOf("") }
//    var autor by remember { mutableStateOf("") }
//    var ano by remember { mutableStateOf("") }
//    var nome by remember { mutableStateOf("") }
//
//    var isEditado by remember { mutableStateOf("") }
//    var textButton by remember { mutableStateOf("adicionar Livros") }
//
//
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .padding(12.dp)
//    ){
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//        ) {
//            Formulario(
//                idLivros = id,
//                titulo = titulo,
//                autor = autor,
//                ano = ano,
//                isEditando = isEditado,
//                funIsEditando = {isEditado = false},
//                funTexButton = {textButton = it},
//                funResetCampos = { titulo = ""},
//
//                viewModel = viewModel
//
//            )
//
//            Column(modifier = Modifier.fillMaxWidth()){
//                LazyColumn(
//                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//                ) {
//                    items(listaLivros){ titulo ->
//                        cardLivros(
//                            titulo = titulo,
//                            funIdlivro = {id = it},
//                            funNome = {nome = it},
//                            funTextbutton = {textButton = it}
//
//                        )
//                    }
//                }
//            }
//        }
//    }
//
//}