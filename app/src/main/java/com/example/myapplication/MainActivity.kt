package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // A Surface é como um container, você pode mudar a cor de fundo
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}


@Composable
fun Login() {
    var User by remember { mutableStateOf("") }
    var Senha by remember { mutableStateOf("") }
    var Resultado by remember { mutableStateOf("") }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 255, 255))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Tela de Login",
            style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Monospace),
            )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = User,
            onValueChange = { User = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "ícone de user"
                )
            },
            placeholder = {
                Text("User", style = TextStyle(fontSize = 20.sp))
            },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(65.dp)
                .background(color = Color(255, 200, 100)),

        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = Senha,
            onValueChange = { Senha = it },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "ícone de senha"
                )
            },
            placeholder = {
                Text("Senha", style = TextStyle(fontSize = 20.sp))
            },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(65.dp)
                .background(color = Color(255, 200, 100))
            )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para disparar efeito de partículas
        Button(onClick = {

            if (User.isEmpty() || Senha.isEmpty()) {
                Resultado = "Fill all the fields"
            } else if (User.isNotEmpty() && Senha.isNotEmpty())
            {
                Resultado = "Login is possible"
            }

        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(10,10,200),   // cor de fundo
                contentColor = Color.White,          // cor do texto/ícone
                disabledContainerColor = Color.Gray, // cor quando desabilitado
                disabledContentColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(50.dp)
        )
        {
            Text("Entrar", style = TextStyle(fontSize = 20.sp))

        }

        Spacer(modifier = Modifier.height(16.dp))

        if (Resultado.isNotEmpty()) {
            Text(
                text = Resultado,
                color = Color.Red,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )
            )
        }

    }
}

@Preview
@Composable
fun comparacaoPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Álcool ou Gasolina")
    }
}