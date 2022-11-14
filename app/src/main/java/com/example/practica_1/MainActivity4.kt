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
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_1.ui.theme.*

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Настройки",
                    fontSize = 20.sp,
                    color = White,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(30.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .offset(x = 350.dp, y = -60.dp)
                        .clickable(onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    Profile::class.java
                                )
                            )
                        })
                )
                Text(
                    text = "Профиль пользователя",
                    fontSize = 20.sp,
                    color = White,
                    fontWeight = FontWeight(300),
                    modifier = Modifier
                        .padding(30.dp)
                        .offset(y = -50.dp)

                )

                    IconButton(onClick = {}) {
                        val context = LocalContext.current
                        Image(
                            painter = painterResource(R.drawable.vector),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .offset(x = 340.dp, y = -115.dp)
                                .clickable(onClick = {
                                    context.startActivity(
                                        Intent(
                                            context,
                                            Profile::class.java
                                        )
                                    )
                                })
                        )
                    }
                    Text(
                        text = "Дата и время",
                        fontSize = 20.sp,
                        color = White,
                        fontWeight = FontWeight(300),
                        modifier = Modifier
                            .padding(30.dp)
                            .offset(y = -120.dp, x = 0.dp)
                    )
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.vector),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .offset(x = 228.dp, y = (-207).dp)

                        )
                        Text(
                        text = "Настройки звука",
                        fontSize = 20.sp,
                        color = White,
                        fontWeight = FontWeight(300),
                        modifier = Modifier
                            .padding(20.dp)
                            .offset(x = -30.dp, y = -145.dp)
                    )
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.vector),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .offset(x = 230.dp, y = -145.dp)
                            )
                             Text(
                             text = "Проверить обновления",
                             fontSize = 20.sp,
                             color = White,
                             fontWeight = FontWeight(300),
                             modifier = Modifier
                                 .padding(30.dp)
                                 .offset(x = 0.dp, y = -(80).dp)
                         )
                            IconButton(onClick = {}) {
                                Image(
                                    painter = painterResource(R.drawable.vector),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .offset(x = 230.dp, y = -(77).dp)
                                )

                            }
                        }
                    }
                Spacer(modifier = Modifier.padding(110.dp))
                RoundedCornerShapeDemo5()
            }
        }
    }
}

@Composable
fun RoundedCornerShapeDemo5() {
    TheBottomPanel4(shape = RoundedCornerShape(20.dp))
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun TheBottomPanel4(shape: Shape) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(320.dp, 100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                    )
                )
                /*.offset(y = 60.dp)*/
                .background(LightGreen)
        ) {
            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity::class.java))}) {
                    Image(
                        painter = painterResource(R.drawable.listred),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "List",
                        fontSize = 15.sp,
                        color = Red,
                        modifier = Modifier.offset(y = 20.dp)
                    )
                }
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity2::class.java))}, modifier = Modifier
                    .width(80.dp)
                    .wrapContentSize(
                        Alignment.Center
                    )) {
                    Image(
                        painter = painterResource(R.drawable.alarm),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 0.dp)
                    )
                    Text(
                        text = "Alarm",
                        fontSize = 15.sp,
                        color = Red,
                        modifier = Modifier.offset(y = 20.dp, x = 0.dp)
                    )
                }
                IconButton(onClick = {},modifier = Modifier
                    .width(90.dp)
                    .wrapContentSize(Alignment.Center)) {
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 0.dp)
                    )
                    Text(
                        text = "Calendar",
                        fontSize = 15.sp,
                        color = Red,
                        modifier = Modifier.offset(y = 20.dp, x = 0.dp)
                    )

                }
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity4::class.java))},modifier = Modifier
                    .width(90.dp)
                    .wrapContentSize(Alignment.Center)) {
                    Image(
                        painter = painterResource(id = R.drawable.settinggreen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 0.dp)
                    )
                    Text(
                        text = "Settings",
                        fontSize = 15.sp,
                        color = DarkGreen,
                        modifier = Modifier.offset(y = 20.dp, x = 0.dp)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Practica_1Theme {
        Greeting3("Android")
    }
}