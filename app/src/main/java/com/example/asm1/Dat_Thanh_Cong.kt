package com.example.asm1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Dat_Thanh_Cong : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        LayoutDHTC()
        }
    }
}

@Preview
@Composable
fun LayoutDHTC() {
    val context= LocalContext.current
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            fontFamily = FontFamily(Font(R.font.merriweather_bold)),
            fontWeight = FontWeight.W700,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
        )
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.dodung),  // Sử dụng Coil để tải ảnh từ URL
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 40.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
            )
            Image(
                painter = painterResource(id = R.drawable.check),  // Sử dụng Coil để tải ảnh từ URL
                contentDescription = null,
                modifier = Modifier
                    .size(65.dp)
                    .padding(5.dp)
                    .align(Alignment.BottomCenter)
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        /////
        Text(
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            fontFamily = FontFamily(Font(R.font.nunitosans_variablefont)),
            fontWeight = FontWeight.W400,
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF242424)),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Track your orders",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                fontWeight = FontWeight.W600
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { context.startActivity(Intent(context,MainActivity::class.java))},
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "BACK TO HOME",
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                fontWeight = FontWeight.W600
            )
        }
    }
}