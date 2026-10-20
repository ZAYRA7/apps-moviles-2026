package com.example.columnapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.columnapplication.ui.theme.ColumnApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnApplicationTheme {
                ViewContainer()
            }
        }
    }
}

// 1. Contenedor Principal basado en Scaffold
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Content(modifier = Modifier.padding(innerPadding))
    }
}

// 2. Componente Toolbar (TopAppBar)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "AristiDevs Profile", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1E1E1E) // Fondo gris oscuro/negro personalizado
        )
    )
}

// 3. Componente Botón Flotante de Acción (FloatingActionButton)
@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Suscríbete", Toast.LENGTH_SHORT).show()
        },
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        Text(text = "X")
    }
}

// 4. Contenido Principal de la Pantalla (LazyColumn)
@Composable
fun Content(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        item {
            // Imagen manteniendo R.drawable.img_1
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Logo AristiDevs",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            // Fila con Ícono de Me Gusta e Incremento
            Row(modifier = Modifier.padding(top = 8.dp, start = 16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            // Título Principal Estilizado y Centrado
            Text(
                text = "AristiDevs",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Textos Adicionales
            Text(
                text = "Suscríbete",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = "Hola",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )

            // Implementación del LazyRow (Scroll Horizontal)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = "Java ", color = Color.White)
                    Text(text = "KOTLIN ", color = Color.White)
                    Text(text = "Suscríbete ", color = Color.White)
                }
            }
        }
    }
}

// Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ColumnApplicationTheme {
        ViewContainer()
    }
}