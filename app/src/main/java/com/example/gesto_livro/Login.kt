package com.example.gesto_livro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gesto_livro.ui.theme.ShapeEditText

@Composable
fun Login(
    Tela_inicial: () -> Unit,
    Tela_Cliente: () -> Unit

) {
    // Layout principal com a imagem de fundo
    Box(modifier = Modifier.fillMaxSize()) {
        // Imagem de fundo
        // Conteúdo do Scaffold sobre a imagem
        Scaffold(
            containerColor = Color.Transparent, // Deixa o fundo do Scaffold transparente
            content = { paddingValues ->
                val context = LocalContext.current
                var user by remember { mutableStateOf("") }
                var pass by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = "Gestor de livros",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        value=user,
                        onValueChange = {
                            user = it
                        },
                        label = { Text("Username ") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        shape = ShapeEditText.small,
                    )


                    // Campo Password
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        value = pass,
                        onValueChange = { pass = it },
                        label = { Text("Password") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = ShapeEditText.small
                    )

                    // Botão de login
                    Button(
                        onClick = {
                            if (user == "admin" && pass == "admin123") {
                                Toast.makeText(context, "Login feito", Toast.LENGTH_SHORT).show()
                                Tela_inicial()
                            } else if (user == "jeovani paxe" && pass == "kingson1976") {
                                Toast.makeText(context, "Login feito", Toast.LENGTH_SHORT).show()
                                Tela_Cliente()
                            } else {
                                Toast.makeText(context, "User ou senha incorreta!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        )
                    ){Text(text = "Log in", fontWeight = FontWeight.Bold, fontSize = 18.sp)}
                }
            }
        )
    }
}
