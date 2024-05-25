package com.example.asm1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Man_Cho : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingWithBackground()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, text1: String) {
    Column(modifier = modifier) {
        Text(
            text = "$name!",
            color = Color(0xFF606060),
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght))
        )
        Text(
            text = "$text1!",
            fontSize = 35.sp,
            fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
            fontWeight = FontWeight.W700,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWithBackground() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Greeting(
                name = "MAKE YOUR",
                modifier = Modifier.padding(16.dp),
                text1 = "HOME BEAUTIFUL"
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 20.sp,
                color = Color(0xFFF5EFEF),
                fontFamily = FontFamily(Font(R.font.nunitosans_variablefont)),
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(30.dp, 0.dp),
                lineHeight = 35.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        val intent = Intent(context, Dang_Nhap::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
                    shape = RoundedCornerShape(5.dp) // Đặt hình dạng là RectangleShape để bỏ bo góc
                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                        fontWeight = FontWeight.W600,
                        lineHeight = 22.85.sp
                    )
                }
            }
        }
    }
}