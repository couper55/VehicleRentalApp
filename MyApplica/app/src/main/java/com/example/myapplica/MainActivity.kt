package com.example.myapplica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplica.WelcomButtonWithImage
import com.example.myapplica.ui.theme.MyApplicaTheme
import android.content.res.Resources
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicaTheme {
                // A surface container using the 'background' color from the theme
                val drawable = ContextCompat.getDrawable(this, R.drawable.kobe)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun WelcomButtonWithImage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp,
                vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(380.dp)
                .height(58.dp)
                .clip(shape = RoundedCornerShape(25.dp))
                .background(Color(0xff353392))
        ) {
            Text(
                text = "I am new here",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Image(
                painter = Painter(drawable = drawable),
                contentDescription = "My image",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(24.dp)
            )
        }
        Box(
            modifier = Modifier
                .width(380.dp)
                .height(58.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Text(
                text = "I have an account",
                color = Color(0xff16161a),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically))
        }
    }
}


@Preview
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    WelcomButtonWithImage()
}
