package com.example.asm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Setting : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LayoutSetting() }
    }
}

@Preview
@Composable
fun LayoutSetting() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(
            title = "Setting",
            icon = R.drawable.back,
            icon2 = null,
            onClickButtontTrai = {if (context is ComponentActivity) context.finish()},
            modifier = Modifier.width(270.dp)
        )
        LazyColumn {
            item {
                Tieu_De(
                    name = "Personal Information",
                    onClickedit = {  },
                    icon = R.drawable.edit,
                    modifier = Modifier.padding(20.dp)
                )
                Content(   ten = "Name",
                    noidung = "Bruno Pham",
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp))
                )
                Content(   ten = "Email",
                    noidung = "doandtph42307@fpt.edu.vn",
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp))
                )

            }
            item {
                Tieu_De(
                    name = "Password",
                    onClickedit = {},
                    icon = R.drawable.edit,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
                )
                Content(
                        ten = "Name",
                noidung="***** **** ****",
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(4.dp, RoundedCornerShape(4.dp))
                )
            }
            item {
                Tieu_De(
                    name = "Notifications",
                    onClickedit = {},
                    icon = null,
                    modifier = Modifier.padding(20.dp)
                )
                Content_ICon(
                    ten = "Sale",
                    icon = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp))
                )
                Content_ICon(
                        ten = "New arrivals",
                icon = null,
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(4.dp, RoundedCornerShape(4.dp))
                )
                Content_ICon(
                    ten = "Delivery status changes",
                    icon = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp))
                )
            }
            item {
                Tieu_De(
                    name = "Help Center",
                    onClickedit = {  },
                    icon = R.drawable.edit,
                    modifier = Modifier.padding(20.dp)
                )
                Content_ICon(
                    ten = "FAQ",
                    icon = R.drawable.next,
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp))
                )

            }
        }
    }
}

@Composable
private fun Tieu_De(
    name: String,
    modifier: Modifier = Modifier,
    onClickedit: () -> Unit,
    icon: Int?
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            color = Color.Gray,
            fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
        )
        icon?.let {
            androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

@Composable
private fun Content(
    ten: String?,
    noidung: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(13.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            ten?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                )
            }
            Text(
                text = noidung,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
            )
        }
    }
}
@Composable
private fun Content_ICon(
    ten: String?,
    icon: Int?,
    modifier: Modifier = Modifier,
) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(13.dp)
            .clickable { checked = !checked },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
            ten?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                )
            }
        Spacer(modifier = Modifier.weight(1f))
        if (icon == null) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF27AE60),
                    uncheckedTrackColor = Color.Gray
                )
            )
        } else {
            androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = icon), contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}




