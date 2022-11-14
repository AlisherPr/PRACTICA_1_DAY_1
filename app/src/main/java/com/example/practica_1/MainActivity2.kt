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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_1.ui.theme.*

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()
            ) {
                Text(text = "Будильник", fontSize = 20.sp, color = White, fontWeight = FontWeight(600), modifier = Modifier.padding(30.dp))
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "Avatar", modifier = Modifier
                    .size(50.dp)
                    .offset(x = 350.dp, y = (-60).dp)
                    .clickable (onClick ={context.startActivity(Intent(context, Profile::class.java))}))
                Text(text = "07:30", fontSize = 50.sp, color = White, fontWeight = FontWeight(600), modifier = Modifier
                    .padding(30.dp)
                    .offset(y = -40.dp)
                    .clickable(onClick = {context.startActivity(Intent(context, EditAlarm::class.java))}))
                Switch1()
                Text(text = "08:00", fontSize = 50.sp, color = White, fontWeight = FontWeight(600), modifier = Modifier
                    .padding(30.dp)
                    .offset(y = -80.dp))
                Switch2()
                ButtonAdd(name = "Добавить будильник", color = LightGreen, textSize = 19, paddingTop = 48)
                Spacer(modifier = Modifier.padding(24.dp))
            RoundedCornerShapeDemo3()
        }
    }
}

@Composable
fun Switch1()
{
    val checkedState = remember { mutableStateOf(false)}
    Switch(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFFFFFFFF),
            checkedTrackColor = Color(0xFFAAF683),
            uncheckedThumbColor = Color(0xFFFFFFFF),
            uncheckedTrackColor = Color(0xFFFF9B85)
        ),
        modifier = Modifier
            .offset(x = 170.dp, y = -125.dp)
            .size(90.dp, 45.dp)
            .offset(x = 125.dp, y = 5.dp)
            .background(
                color = (if (checkedState.value) {
                    Color(0xFFAAF683)
                } else {
                    Color(0xFFFF9B85)
                }), shape = RoundedCornerShape(25.dp)
            )
    )
}

@Composable
fun Switch2(){
    val checkedState = remember { mutableStateOf(false) }
    val checkedState1 = remember { mutableStateOf(false) }
    Row (verticalAlignment = Alignment.CenterVertically ) {
        Switch(
            checked = checkedState1.value,
            onCheckedChange = {
                checkedState1.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFFFFFFFF),
                checkedTrackColor = Color(0xFFAAF683),
                uncheckedThumbColor = Color(0xFFFFFFFF),
                uncheckedTrackColor = Color(0xFFFF9B85)
            ),
            modifier = Modifier
                .size(90.dp, 45.dp)
                .offset(x = 300.dp, y = -165.dp)
                .background(
                    color = (if (checkedState1.value) {
                        Color(0xFFAAF683)
                    } else {
                        Color(0xFFFF9B85)
                    }), shape = RoundedCornerShape(25.dp)
                )
        )
    }
}

    @Composable
    fun ButtonAdd(name: String, color: Color,textSize: Int, paddingTop:Int){
        val context = LocalContext.current
        Row(modifier = Modifier
            .padding(bottom = 1.dp, top = paddingTop.dp, start = 28.dp, end = 28.dp)
            .size(428.dp, 78.dp)) {
            Button(
                onClick = {context.startActivity(
                    Intent(context, CreateAlarmActivity::class.java)
                )},
                colors = ButtonDefaults.buttonColors(color),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(348.dp, 48.dp)
                    .clip(RoundedCornerShape(5.dp)))
            {
                Text(text = name, style = TextStyle(color = White, fontSize = textSize.sp))
            }
        }
    }

@Composable
fun RoundedCornerShapeDemo3() {
    TheBottomPanel2(shape = RoundedCornerShape(20.dp))
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun TheBottomPanel2(shape: Shape) {
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
                IconButton(onClick = {}, modifier = Modifier
                    .width(80.dp)
                    .wrapContentSize(
                        Alignment.Center
                    )) {
                    Image(
                        painter = painterResource(R.drawable.greenalarm),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 0.dp)
                    )
                    Text(
                        text = "Alarm",
                        fontSize = 15.sp,
                        color = DarkGreen,
                        modifier = Modifier.offset(y = 20.dp, x = 0.dp)
                    )
                }
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity3::class.java))},modifier = Modifier
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
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 0.dp)
                    )
                    Text(
                        text = "Settings",
                        fontSize = 15.sp,
                        color = Red,
                        modifier = Modifier.offset(y = 20.dp, x = 0.dp)
                    )

                }
            }
        }
    }
}


@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Practica_1Theme {
        Greeting2("Android")
    }
}
}