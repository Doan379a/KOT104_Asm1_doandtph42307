package com.example.asm1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

data class ButtonData(val icon: Int, val noidung: String)
data class DSsanpham(val img: Int, val icon: Int, val text: String, val text2: String)

class Trang_Chu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOTrang_Chu()
        }
    }
}

@Preview
@Composable
fun LOTrang_Chu() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White).padding(horizontal = 5.dp)
    ) {
        TopBar(title = "Make home")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 10.dp) // Add padding around the entire LazyColumn
        ) {
            item {

            }

            item {
                val buttons = listOf(
                    ButtonData(R.drawable.star_1, "Popular"),
                    ButtonData(R.drawable.chair_4, "Chair"),
                    ButtonData(R.drawable.table, "Table"),
                    ButtonData(R.drawable.sofa1, "Armchair"),
                    ButtonData(R.drawable.bed1, "Bed"),
                    ButtonData(R.drawable.star_1, "Popular"),
                    ButtonData(R.drawable.chair_4, "Chair"),
                    ButtonData(R.drawable.table, "Table"),
                    ButtonData(R.drawable.sofa1, "Armchair"),
                    ButtonData(R.drawable.bed1, "Bed")
                )
                meNuNgang(buttons)
            }

            val dSsanpham = listOf(
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00"),
                DSsanpham(R.drawable.img, R.drawable.frame19, "Black Simple Lamp", "$ 12.00")
            )
            items(dSsanpham.chunked(2)) { chunkedList ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    for (ds in chunkedList) {
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ItemSanpham(
                                img = ds.img,
                                icon = ds.icon,
                                text2 = ds.text2,
                                text = ds.text,
                                onItemClick = {
                                    val intent = Intent(context, Product::class.java)
//                                    intent.putExtra("KEY_NAME", "Giá trị cần chuyển")
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp)
            .padding( vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.IconButton(onClick = { /* mở màn hình tìm kiếm */ }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Tìm kiếm",
                tint = Color(0xFF808080),
                modifier = Modifier
                    .size(35.dp)
            )
        }
        Column() {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300,
                color = Color(0xFF808080),
                fontFamily = FontFamily(Font(R.font.gelasio_italic_variablefont_wght)),
            )
            Text(
                text = "BEAUTIFUL",
                modifier = Modifier.offset(x = -15.dp),
                fontSize = 23.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(Font(R.font.gelasio_italic_variablefont_wght))
            )
        }
        androidx.compose.material3.IconButton(onClick = { /* mở màn hình giỏ hàng */ }) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Giỏ hàng",
                tint = Color(0xFF808080),
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}

@Composable
private fun meNuNgang(buttons: List<ButtonData>) {
    var selectedButton by remember { mutableStateOf(buttons.firstOrNull()) }
    LazyRow(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Adds spacing between items
    ) {
        items(buttons) { buttonData ->
            IconButton(
                icon = buttonData.icon,
                noidung = buttonData.noidung,
                isSelected = selectedButton == buttonData,
                onClick = { selectedButton = buttonData }
            )
        }
    }
}

@Composable
fun IconButton(icon: Int, noidung: String, isSelected: Boolean, onClick: () -> Unit) {
    val image: Painter = painterResource(id = icon)
    val backgroundColor = if (isSelected) {
        Color.Black
    } else {
        Color(0xFFF5F5F5)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp) // Add padding around each item
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor, shape = RoundedCornerShape(10.dp))
                .height(60.dp)
                .width(60.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = image, tint = if (isSelected) Color.White else Color(0xFF727070),
                contentDescription = noidung,
                modifier = Modifier.size(30.dp)
            )
        }

        Text(
            text = noidung,
            fontSize = 14.sp,
            color = if (isSelected) Color.Black else Color(0xFF727070),
            modifier = Modifier.padding(top = 4.dp) // Add space between image and text
        )
    }
}

@Composable
private fun ItemSanpham(img: Int, icon: Int, text: String, text2: String, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = onItemClick)
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(20.dp)
                )

        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(20.dp)), // Lấp đầy kích thước của Box
                contentScale = ContentScale.Crop
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Căn chỉnh Icon vào góc dưới bên phải
                    .size(50.dp)
                    .padding(10.dp)
            )
        }
        Text(
            text = "$text",
            fontSize = 15.sp,
            color = Color(0xFF606060),
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily(Font(R.font.nunitosans_variablefont))
        )
        Text(
            text = "$text2",
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            lineHeight = 19.1.sp,
            fontFamily = FontFamily(Font(R.font.nunitosans_variablefont))
        )
    }
}
