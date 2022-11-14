package com.example.practica_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.MarginLayoutParamsCompat
import com.example.practica_1.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .background(Green)
                    .fillMaxSize()
            ) {
                Text(text = "Список дел", fontSize = 20.sp, color = White, fontWeight = FontWeight(600), modifier = Modifier.padding(30.dp))
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "Avatar", modifier = Modifier
                    .size(50.dp)
                    .offset(x = 350.dp, y = -60.dp)
                    .clickable (onClick = {context.startActivity(Intent(context, Profile::class.java))}))
                RoundedCornerShapeDemo()
                ButtonAdd(name = "Добавить задачу", color = LightGreen, textSize = 19, paddingTop = 48)
                Spacer(modifier = Modifier.padding(10.dp))
                RoundedCornerShapeDemo2()
            }

        }
    }
}

@Composable
fun RoundedCornerShapeDemo(){
    ExampleBox(shape = RoundedCornerShape(20.dp))
    Spacer(modifier = Modifier.height(10.dp))
    ExampleBox2(shape = RoundedCornerShape(20.dp))
    Spacer(modifier = Modifier.height(10.dp))
    ExampleBox3(shape = RoundedCornerShape(20.dp))
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun RoundedCornerShapeDemo2(){
    TheBottomPanel(shape = RoundedCornerShape(20.dp))
}

@Composable
fun ExampleBox(shape: Shape){
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center))
    {
        Box(modifier = Modifier
            .size(380.dp, 110.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 0.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 0.dp,
                )
            )
            .background(Yellow)
            .clickable (onClick = {context.startActivity(Intent(context, EditTaskActivity::class.java))})){
            Row(
                modifier = Modifier.padding(12.dp)

            ) {

                Column(modifier = Modifier.padding(12.dp)

                ) {
                    Text(text = "Вечерний поход в кино", fontSize = 20.sp, color = White )
                    Text(text = "Идем в кино с коллегами", fontSize = 15.sp, color = Grey)
                }
                Column(modifier = Modifier.padding(19.dp)

                        )
                {
                    Text(text = "10.02.2021",fontSize = 14.sp, color = Grey)
                    Text(text = "19:40", fontSize = 14.sp, color = Grey)
                }

            }


        }
    }
}

@Composable
fun ExampleBox2(shape: Shape){
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(modifier = Modifier
            .size(380.dp, 110.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 0.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 0.dp,
                )
            )
            .background(Yellow)
            .clickable (onClick = {context.startActivity(Intent(context, EditTaskActivity::class.java))})){
            Row(
                modifier = Modifier.padding(12.dp)
            ) {

                Column(modifier = Modifier.padding(12.dp)

                ) {
                    Text(text = "Забрать заказ Ozon", fontSize = 20.sp, color = White )
                    Text(text = "Пункт выдачи на ул. Ленина,103", fontSize = 15.sp, color = Grey)
                }
                Column(modifier = Modifier.padding(17.dp)

                )
                {
                    Text(text = "10.02.2021",fontSize = 14.sp, color = Grey)
                    Text(text = "19:40", fontSize = 14.sp, color = Grey)
                }

            }
        }
    }
}

@Composable
fun ExampleBox3(shape: Shape){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(modifier = Modifier
            .size(380.dp, 110.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 0.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 0.dp,
                )
            )
            .background(Yellow)){
            Row(
                modifier = Modifier.padding(12.dp)
            ) {

                Column(modifier = Modifier.padding(12.dp)

                ) {
                    Text(text = "Запись в автосервис", fontSize = 20.sp, color = White )
                    Text(text = "Сдать автомобиль на ул.\nБисертская,д.14. Замена масла", fontSize = 15.sp, color = Grey)
                }
                Column(modifier = Modifier.padding(19.dp)

                )
                {
                    Text(text = "10.02.2021",fontSize = 14.sp, color = Grey)
                    Text(text = "19:40", fontSize = 14.sp, color = Grey)
                }

            }
        }
    }
}

@Composable
fun ButtonAdd(name: String, color: Color,textSize: Int, paddingTop:Int){
    val context = LocalContext.current
   Row(modifier = Modifier
       .padding(bottom = 1.dp, top = paddingTop.dp, start = 28.dp, end = 28.dp)
       .size(428.dp, 78.dp)) {
       Button(
           onClick = {context.startActivity(Intent(context, AddTaskActivity::class.java))},
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
fun TheBottomPanel(shape: Shape) {
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
                .background(LightGreen)
        ) {
            val context = LocalContext.current
            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.list),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "List",
                        fontSize = 15.sp,
                        color = DarkGreen,
                        modifier = Modifier.offset(y = 20.dp)
                    )
                }
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity2::class.java))}, modifier = Modifier.width(80.dp).wrapContentSize(Alignment.Center)) {
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
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity3::class.java))},modifier = Modifier.width(90.dp).wrapContentSize(Alignment.Center)) {
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
                IconButton(onClick = {context.startActivity(Intent(context, MainActivity4::class.java))},modifier = Modifier.width(90.dp).wrapContentSize(Alignment.Center)) {
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
fun Greeting(name: String) {
    Column {

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Practica_1Theme {
    }
}
