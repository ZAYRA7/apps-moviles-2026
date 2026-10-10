package com.example.columnapplication

import android.os.Bundle
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    // LazyColumn principal (Scroll Vertical)
    var counter by rememberSaveable { mutableStateOf (value = 0)}
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        item {
            // 1. Imagen manteniendo img_1
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Logo AristiDevs",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Row (modifier = Modifier.padding(top = 8.dp )){
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable {counter++}
                )
                Text(text = counter.toString(), color = Color.White, modifier = Modifier.padding(start = 4.dp))
            }

            // 2. Título Principal Estilizado y Centrado
            Text(
                text = "AristiDevs",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // 3. Textos Adicionales
            Text(
                text = "Suscríbete",
                color = Color.White
            )

            Text(
                text = "Hola",
                color = Color.White
            )

            // 4. Implementación del LazyRow (Scroll Horizontal)
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
        App()
    }
}