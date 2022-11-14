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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.practica_1.ui.theme.Green
import com.example.practica_1.ui.theme.LightGreen
import com.example.practica_1.ui.theme.Practica_1Theme
import com.example.practica_1.ui.theme.White

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()
            ){
                Text(
                    text = "Профиль пользователя",
                    fontSize = 20.sp,
                    color = White,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(30.dp)
                )
                val context = LocalContext.current
                Image(painter = painterResource(id = R.drawable.backbutton), contentDescription = "avatar", modifier = Modifier
                    .size(50.dp)
                    .offset(x = 350.dp, y = (-70).dp)
                    .clickable(onClick = {
                        context.startActivity(
                            Intent(context,MainActivity4::class.java)
                        )
                    }))
                Image(painter = painterResource(id = R.drawable.bigavatar), contentDescription = "avatar", modifier = Modifier
                    .size(280.dp)
                    .offset(x = 65.dp, y = 20.dp))
                Text(text = "Вход не выполнен", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight(300), modifier = Modifier
                    .padding(50.dp)
                    .offset(x = 70.dp, y = -20.dp))
                Row (modifier = Modifier.offset(x = 0.dp, y = -20.dp)){
                    ButtonSignin("Войти")
                }
                Row (modifier = Modifier.offset(x = 0.dp, y = -10.dp)){
                    ButtonSignup("Регистрация")
                }
            }
        }
    }
}

@Composable
fun ButtonSignin(name: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = {val intent = Intent(context,Sing_in::class.java)
            ContextCompat.startActivity(context,intent, null)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen),
            modifier = Modifier
                .size(340.dp, 50.dp)
                .clip(RoundedCornerShape(20))
        ) {
            Text(
                text = name,
                color = MaterialTheme.colors.background,
                fontSize = 18.sp, fontWeight = FontWeight(400)
            )
        }
    }
}

@Composable
fun ButtonSignup(name: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = {val intent = Intent(context,Sing_up::class.java)
            ContextCompat.startActivity(context,intent, null)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen),
            modifier = Modifier
                .size(340.dp, 50.dp)
                .clip(RoundedCornerShape(20))
        ) {
            Text(
                text = name,
                color = MaterialTheme.colors.background,
                fontSize = 18.sp, fontWeight = FontWeight(400)
            )
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Practica_1Theme {
        Greeting4("Android")
    }
}