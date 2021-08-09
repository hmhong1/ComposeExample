package com.example.newfoxproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")

    var isSelected by remember { mutableStateOf(false) }
    val bc by animateColorAsState(if(isSelected) Color.Red else Color.Transparent)
    var count by remember { mutableStateOf(0) }

    Text(text = "Hello $name!! text click count : $count",
        modifier = Modifier
            .padding(24.dp)
            .background(color = bc)
            .clickable {
                isSelected = !isSelected
                count++
            })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Column{
            Greeting("Android1")

            Image(painter = painterResource(id = R.drawable.image01),
                contentDescription = null,
                modifier = Modifier.padding(2.dp)
                                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop)

            MyScreenContent()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column {
        Greeting("Android2")
        Divider(color = Color.Black)
        Greeting("android jatpack compose example!! long text testing~")
    }
}

@Composable
fun MyApp(content : @Composable () -> Unit){
    Surface(color = Color.Yellow) {
        content()
    }
}