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
import com.example.practica_1.ui.theme.Green
import com.example.practica_1.ui.theme.Practica_1Theme
import com.example.practica_1.ui.theme.Red
import com.example.practica_1.ui.theme.White

class EditAlarm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize())
            {
                Text(
                    text = "Изменить будильник",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(30.dp)
                )
                Image(painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .size(50.dp)
                        .offset(x = 350.dp, y = -70.dp)
                        .clickable(onClick = {
                            context.startActivity(
                                Intent(context, MainActivity2::class.java)
                            )
                        })
                )
                Row() {
                    Timeline()
                }
                Row() {
                    Text(text = "Повторять каждый", color = White, modifier = Modifier.offset(x =30.dp, y = -20.dp), fontSize = 18.sp, fontWeight = FontWeight(300))
                }
                Row() {
                    CheckView()
                }
                Row(modifier = Modifier.offset(y=230.dp)) {
                    ButtonAdd6("Создать будильник")
                }
                Row(modifier = Modifier.offset(y=115.dp)) {
                    ButtonDeleteAlarm("Удалить будильник")
                }
            }
        }
    }
}
@Composable
fun ButtonDeleteAlarm(name: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = {context.startActivity(Intent(context, MainActivity2::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
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

