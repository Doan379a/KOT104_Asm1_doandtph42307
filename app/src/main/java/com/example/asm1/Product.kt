package com.example.asm1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Product : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layout()
        }
    }
}

@Preview
@Composable
private fun Layout() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Duoi()
        Back()
        Row(
            modifier = Modifier
                .heightIn(70.dp)
                .background(Color.White)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        Color(0xFFF0F0F0), shape = RoundedCornerShape(7.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.v2), contentDescription = "yeu thich",
                    modifier = Modifier.size(20.dp)
                )
            }
            Button(
                onClick = {
                    val intent = Intent(context, My_Cart::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .width(270.dp)
                    .padding(end = 27.dp)
                    .heightIn(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF242424)),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Add to cart",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W600,
                    modifier = Modifier
                )

            }

        }
    }
}

@Composable
private fun Back() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    )
    {
        Box(
            modifier = Modifier
                .offset(x = 22.dp, y = 52.dp) // Vị trí của IconButton
                .background(
                    Color(0xBCF5F1F1),
                    shape = RoundedCornerShape(5.dp)
                ) // Nền đen và hình dạng tròn
                .size(40.dp),
            contentAlignment = Alignment.Center // Đảm bảo IconButton được căn giữa trong Box
        ) {
            androidx.compose.material3.IconButton(
                onClick = {
                    if (context is ComponentActivity) {
                        context.finish()
                    }
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back), contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .alpha(1F)
                )
            }
/////////////////

        }
    }
}

@Composable
fun HinhTron(
    backgroundColor: Color,
    borderColor: Color,
    borderThickness: Dp,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderThicknessPx = with(LocalDensity.current) { borderThickness.toPx() }
    Canvas(modifier = Modifier
        .size(50.dp)
        .padding(5.dp)
        .pointerInput(Unit) {
            detectTapGestures(onTap = { onClick() })
        }) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val outerRadius = size.width / 2
        val innerRadius = outerRadius - borderThicknessPx
        // Vẽ hình tròn ngoài (màu viền)
        drawCircle(
            color = if (isSelected) Color.Gray else borderColor,
            radius = outerRadius,
            center = Offset(centerX, centerY)
        )

        // Vẽ hình tròn trong (màu bên trong)
        drawCircle(
            color = backgroundColor,
            radius = innerRadius,
            center = Offset(centerX, centerY)
        )
    }
}



@Composable
private fun Duoi() {
    // Biến trạng thái để lưu màu hiện tại
    val selectedColorIndex = remember { mutableStateOf<Int?>(null) }

    Column(modifier = Modifier.padding(start = 10.dp)) {
        //////thanh mau
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .offset(x = 35.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 50.dp))
            )
            Column(
                modifier = Modifier
                    .heightIn(max = 192.dp)
                    .size(64.dp, 192.dp)
                    .padding(start = 10.dp)
                    .background(
                        Color(0xE6F5F1F1),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .align(Alignment.CenterStart), verticalArrangement = Arrangement.Center
            ) {
                HinhTron(
                    backgroundColor = Color.White,
                    borderColor = Color(0xEDC9C5C5),
                    borderThickness = 5.dp,
                    isSelected = selectedColorIndex.value == 0,
                    onClick = { selectedColorIndex.value = 0 }
                )
                HinhTron(
                    backgroundColor = Color(0xFFB4916C),
                    borderColor = Color(0x7EE2E1E1),
                    borderThickness = 5.dp,
                    isSelected = selectedColorIndex.value == 1,
                    onClick = { selectedColorIndex.value = 1 }
                )
                HinhTron(
                    backgroundColor = Color(0xFFE4CBAD),
                    borderColor = Color(0x7EE2E1E1),
                    borderThickness = 5.dp,
                    isSelected = selectedColorIndex.value == 2,
                    onClick = { selectedColorIndex.value = 2 }
                )
            }
        }
////noi dung ben duoi
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Minimal Stand",
                fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                lineHeight = 27.8.sp,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
            ////dong2
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$ 50",
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W700,
                    fontSize = 30.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.width(130.dp)
                ) {
                    androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cong15),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .alpha(0.5F)
                        )
                    }
                    Text(
                        text = "50",
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        letterSpacing = 5.sp
                    )
                    androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.tru23),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .alpha(0.5F)
                        )
                    }
                }
            }
            ///dong3
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sao), contentDescription = null,
                    tint = Color.Yellow, modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "4.5",
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Text(
                    text = "(50 reviews)",
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W700,
                    fontSize = 14.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Gray,
                )
            }
            ////dong4
            Text(
                text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                fontFamily = FontFamily(Font(R.font.nunitosans_variablefont)),
                fontWeight = FontWeight.W700,
                fontSize = 14.sp,
                lineHeight = 27.8.sp,
                color = Color(0xFF606060),
                textAlign = TextAlign.Justify,
            )
        }
    }
}
