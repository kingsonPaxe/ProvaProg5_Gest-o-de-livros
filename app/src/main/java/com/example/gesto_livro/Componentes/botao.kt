package com.example.gesto_livro.Componentes

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gesto_livro.ui.theme.blue
import com.example.gesto_livro.ui.theme.castanho
import com.example.gesto_livro.ui.theme.white

@Composable
fun botao(
    onClick:() -> Unit,
    modifier: Modifier,
    texto: String
){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = castanho,
            contentColor = white
        )

    ) {
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}