package com.example.asm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

data class DanhSachTB(
    val tenHD: String,
    val imgSP: String?,
    val ndTomTat: String,
    val TrangThai: String?
)

val danhsach = listOf(
    DanhSachTB(
        "Your order #123456789 has been confirmed",
       "https://dbhomes.com.vn/media/wysiwyg/den-de-ban-1.jpg",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "New"
    ),
    DanhSachTB(
        "Your order #123456789 has been confirmed",
       "https://th.bing.com/th/id/OIP.br0JmhiKmip-ehef-t4QswAAAA?rs=1&pid=ImgDetMain",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        null
    )
    ,
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        "https://i5.walmartimages.com/seo/Swinton-21-75-Table-Lamp-Gray_f5a136b7-72b7-44c3-b6bc-04729abe9370.656490cc091d0333e52d82f038c3c203.jpeg?odnHeight=640&odnWidth=640&odnBg=FFFFFF",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "Hot"
    )
    ,
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        null,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "Hot"
    )
    ,
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        "https://th.bing.com/th/id/OIP.mMMIkbW4KEuwAs078R3T8wHaHa?w=646&h=646&rs=1&pid=ImgDetMain",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "Hot"
    )
)
class Thong_Bao : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOTong_Bao()
        }
    }
}

@Preview
@Composable
fun LOTong_Bao() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Notification",
            icon = R.drawable.ri_search_2_line,
            icon2 = null,
            modifier = Modifier.width(300.dp),
            onClickButtontTrai = {}
        )
        LazyColumn {
            items(danhsach) { ds ->
                ItemTB(
                    tenHD = ds.tenHD,
                    imgSP = ds.imgSP,
                    ndTomTat = ds.ndTomTat,
                    TrangThai = ds.TrangThai,
                    onClickItem = { /*TODO*/ },
                    modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}

@Composable
private fun ItemTB(
    tenHD: String?,
    imgSP: String?,
    ndTomTat: String?,
    TrangThai: String?,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(if (TrangThai===null) Color.White else Color(0xFFF5F5F5) )
            .padding(start = 4.dp, end = 10.dp)
            .clickable { onClickItem },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        imgSP?.let {
            Image(
                painter = rememberImagePainter(data = it),  // Sử dụng Coil để tải ảnh từ URL
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
        }
        /////
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                tenHD?.let {
                    Text(
                        text = it,
                        fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        lineHeight = 16.37.sp,
                        color = Color.Black,
                        maxLines = 1, // Thiết lập số dòng tối đa
                        overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                    )
                }
                ndTomTat?.let {
                    Text(
                        text = it,
                        fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Justify,
                        maxLines = if (imgSP!=null)3 else 4, // Thiết lập số dòng tối đa
                        overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                    )
                }
            }
            TrangThai?.let {
                Text(
                    text = if (it.equals("Hot")) "${it.uppercase()} !" else it.uppercase(),
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp,
                    lineHeight = 27.8.sp,
                    color = if (it.equals("Hot")) Color.Red else Color(0xFF27AE60),
                    textAlign = TextAlign.Right,
                    maxLines = 1, // Thiết lập số dòng tối đa
                    overflow = TextOverflow.Ellipsis, // Sử dụng dấu ba chấm khi văn bản vượt quá
                    modifier = Modifier.fillMaxWidth() // Đảm bảo nó chiếm hết chiều rộng
                )
            }
        }
    }
}



