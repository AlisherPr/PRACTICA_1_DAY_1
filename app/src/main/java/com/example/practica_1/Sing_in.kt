package com.example.practica_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_1.ui.theme.Green
import com.example.practica_1.ui.theme.LightGreen
import com.example.practica_1.ui.theme.Practica_1Theme
import com.example.practica_1.ui.theme.White

class Sing_in : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()
            ){
                val context = LocalContext.current
                Text(text = "Регистрация", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight(600), modifier = Modifier.padding(30.dp))
                Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = "arrow", modifier = Modifier
                    .size(50.dp)
                    .offset(x = 350.dp, y = (-70).dp)
                    .clickable(onClick = {
                        context.startActivity(
                            Intent(context, MainActivity4::class.java)
                        )
                    }))
                EditText_Username2()
                EditText_Mail()
                EditText_Password2()
                ButtonSign_up("Регистрация", color = LightGreen, textSize = 18, paddingTop = 0)
            }
        }
    }
}

@Composable
fun EditText_Username2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Имя пользователя")},
        modifier = Modifier
            .size(400.dp, 50.dp)
            .padding(start = 26.dp, end = 16.dp)
            .offset(y = 100.dp).clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}
@Composable
fun EditText_Mail(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Адрес электронной почты")},
        modifier = Modifier
            .size(420.dp, 52.dp)
            .padding(start = 26.dp, end = 26.dp)
            .offset(y = 120.dp).clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}
@Composable
fun EditText_Password2(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text(text = "Пароль")},
        modifier = Modifier
            .size(420.dp, 52.dp)
            .padding(start = 26.dp, end = 26.dp)
            .offset(y = 140.dp).clip(RoundedCornerShape(7.dp)), colors = TextFieldDefaults.textFieldColors(backgroundColor = White, cursorColor = Color.Black, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent)
    )
}

@Composable
fun ButtonSign_up(name: String, color: Color, textSize: Int, paddingTop: Int){
    val context = LocalContext.current
    Row(modifier = Modifier
        .padding(bottom = 0.dp, top = paddingTop.dp, start = 28.dp, end = 28.dp)
        .size(440.dp, 78.dp).offset(y = 155.dp)){
        Button(onClick = {context.startActivity(Intent(context, Profile::class.java))}, colors = ButtonDefaults.buttonColors(color), modifier = Modifier
            .fillMaxWidth()
            .size(438.dp, 48.dp)
            .clip(
                RoundedCornerShape(5.dp)
            ))
        {
            Text(text = name, style = TextStyle(color = Color.White, fontSize = textSize.sp))
        }
    }
}

@Composable
fun Greeting5(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Practica_1Theme {
        Greeting5("Android")
    }
}