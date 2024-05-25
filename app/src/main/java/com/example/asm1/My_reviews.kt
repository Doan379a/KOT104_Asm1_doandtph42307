package com.example.asm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

private data class DanhsachRV(
    val img: Int,
    val tenSP: String,
    val giaSp: String,
    val ngayTN: String,
    val noidung: String
)

class My_reviews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LayoutMy_reivew() }
    }
}

@Preview
@Composable
fun LayoutMy_reivew() {
    val danhsach = listOf(
        DanhsachRV(
            R.drawable.img_1,
            "Coffee Table",
            "50.00",
            "20/03/2020",
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
        ),
        DanhsachRV(
            R.drawable.img_1,
            "Coffee Table",
            "50.00",
            "20/03/2020",
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
        ),
        DanhsachRV(
            R.drawable.img_1,
            "Coffee Table",
            "50.00",
            "20/03/2020",
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
        ),
        DanhsachRV(
            R.drawable.img_1,
            "Coffee Table",
            "50.00",
            "20/03/2020",
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
        ),
    )
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            title = "My reviews",
            icon = R.drawable.back,
            icon2 = R.drawable.ri_search_2_line,
            onClickButtontTrai = { if (context is ComponentActivity) context.finish() })
        LazyColumn {
            items(danhsach) { ds ->
                Item_Review(
                    img = ds.img,
                    tenSP = ds.tenSP,
                    giaSp = ds.giaSp,
                    ngayTN = ds.ngayTN,
                    noidung = ds.noidung,
                    modifier = Modifier.padding(10.dp).shadow(2.dp, RoundedCornerShape(4.dp))
                )

            }
        }
    }
}

@Composable
private fun Item_Review(
    img: Int,
    tenSP: String,
    giaSp: String,
    ngayTN: String,
    noidung: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White, shape = RoundedCornerShape(4.dp))
            .padding(15.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                , contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth().padding(start = 20.dp)) {
                Text(
                    text = tenSP,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 27.8.sp,
                    color = Color(0xFF606060),
                    textAlign = TextAlign.Justify,
                    maxLines = 1, // Thiết lập số dòng tối đa
                    overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                )
                Text(
                    text = "$" + giaSp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W800,
                    fontSize = 16.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Black,
                    maxLines = 1, // Thiết lập số dòng tối đa
                    overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                )
            }
        }
        //////
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
        ) {
            Row(modifier = Modifier.width(100.dp)) {
                Sao()
                Sao()
                Sao()
                Sao()
                Sao()

            }
            Text(
                text = ngayTN,
                fontFamily = FontFamily(Font(R.font.nunitosans)),
                fontWeight = FontWeight.W300,
                fontSize = 12.sp,
                lineHeight = 27.8.sp,
                color = Color.Gray,
                textAlign = TextAlign.Right,
                overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá

            )
        }
        Text(
            text = noidung,
            fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            lineHeight = 19.1.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify,
            maxLines = 5, // Thiết lập số dòng tối đa
            overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
        )
    }
}

@Composable
fun Sao() {
    Icon(
        painter = painterResource(id = R.drawable.sao), contentDescription = null,
        tint = Color.Yellow,
        modifier = Modifier
            .size(18.dp)
            .padding(2.dp)
    )
}