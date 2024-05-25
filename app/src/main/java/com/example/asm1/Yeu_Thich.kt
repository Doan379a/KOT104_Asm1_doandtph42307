package com.example.asm1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DanhsachYT(val img: Int, val text1: String, val gia: String)


class Yeu_Thich : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOYeu_Thich()
        }
    }
}

@Preview
@Composable
fun LOYeu_Thich() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            TopBar(title = "Favorites"
                , icon = R.drawable.ri_search_2_line
                , icon2 = R.drawable.cart
            , onClickButtontTrai = {})
            val danhsachyt = listOf(
                DanhsachYT(R.drawable.img_1, "Coffee Table", "$ 20.00"),
                DanhsachYT(R.drawable.img_1, "Coffee Table", "$ 20.00"),
                DanhsachYT(R.drawable.img_1, "Coffee Table", "$ 20.00"),
                DanhsachYT(R.drawable.img_1, "Coffee Table", "$ 20.00"),
                DanhsachYT(R.drawable.img_1, "Coffee Table", "$ 20.00"),
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 70.dp) // Padding to avoid the button
            ) {
                items(danhsachyt) { ds ->
                    ItemYT(
                        text = ds.text1,
                        img = ds.img,
                        gia = ds.gia,
                        modifier = Modifier.fillMaxWidth(),
                        onClickItem = {})
                    Divider(
                        color = Color.Gray,
                        thickness = 0.3.dp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }
            }
        }
        // Positioned button at the bottom center
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF242424)),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Add all to my cart",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W600
                )
            }
        }
    }
}


@Composable
private fun ItemYT(text: String, img: Int, gia: String, modifier: Modifier = Modifier, onClickItem: () -> Unit
) {
    Row(
        modifier = modifier.clickable(onClick = onClickItem),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Column(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                )
                Text(
                    text = gia,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                )
            }
        }
        // Spacer to add space between the second column and the third column
        Spacer(modifier = Modifier.width(16.dp))
        // Third Column
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxHeight()
        ) {
            androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.shape),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
            androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.frame19),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .alpha(0.6F),
                    tint = Color.Gray
                )
            }
        }
    }
}
