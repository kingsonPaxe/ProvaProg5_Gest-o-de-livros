package com.example.gesto_livro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gesto_livro.Screens_admin.Add_livros
import com.example.gesto_livro.Screens_admin.Add_livrosViewModel
import com.example.gesto_livro.Screens_admin.LivroDetails
import com.example.gesto_livro.Screens_admin.TelaCliente
import com.example.gesto_livro.Screens_admin.Tela_inicial
import com.example.gesto_livro.consumindoAPI.LivrosViewModel
import com.example.gesto_livro.ui.theme.Gestão_LivroTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Gestão_LivroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Login"
                    ){
                        composable("Login"){
                            Login(
                                Tela_Cliente = {
                                    navController.navigate("TelaCliente")
                                },
                                Tela_inicial = {
                                    navController.navigate("Tela_inicial")
                                }
                            )
                        }
                        composable("Tela_inicial"){
                            Tela_inicial(
                                adicionarLivro = {
                                    navController.navigate("Add_livros")
                                }
                            )
                        }

                        composable("Add_livros"){
                            Add_livros(
                                TelaInicial = {
                                    navController.navigate("Tela_inicial")
                                }
                            )
                        }

                        composable("TelaCliente"){
                            TelaCliente()
                        }

                    }

                }
            }
        }
    }
}
