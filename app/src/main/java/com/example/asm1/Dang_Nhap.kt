@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Dang_Nhap : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Layout() }
    }
}

@Preview(showBackground = true)
@Composable
private fun Layout() {
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Header()
        ContentText(
            text1 = "Hello !",
            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 50.dp),
            text2 = "WELCOME BACK"
        )
        ContentEdit()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .width(120.dp)
                .background(Color(0xFFBDBDBD))
        )
        Image(
            painter = painterResource(id = R.drawable.kot1),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .width(120.dp)
                .background(Color(0xFFBDBDBD))
        )
    }
}

@Composable
private fun ContentText(text1: String, modifier: Modifier, text2: String) {
    Column(modifier = modifier) {
        Text(
            text = "$text1!", fontSize = 24.sp,
            color = Color(0xFFC909090),
        )
        Spacer(modifier = Modifier.heightIn(20.dp))
        Text(
            text = "$text2!", fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContentEdit() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 40.dp),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .offset(x = (-25).dp) // Dịch chuyển sang trái 16.dp
                .fillMaxSize()
                .shadow(4.dp, RoundedCornerShape(4.dp))
                .background(Color.White, RoundedCornerShape(4.dp))
                .padding(top = 50.dp)
        ) {
            TextField(
                value = email,
                onValueChange = { newValue ->
                    email = newValue
                },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp, 0.dp, 0.dp, 50.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            )

            TextField(
                value = password,
                onValueChange = { newValue ->
                    password = newValue
                },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp, 0.dp, 0.dp, 50.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible },
                        modifier = Modifier.padding(end = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = if (passwordVisible) R.drawable.eye else R.drawable.hidden),
                            contentDescription = "Toggle password visibility",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(Color.Gray)
                        )
                    }
                }
            )
        }
        Forgotpass_LG_SU()
    }
}

@Composable
private fun Forgotpass_LG_SU() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = "Forgot Password",
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(320.dp)
                .padding(end = 27.dp)
                .heightIn(50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF242424)),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(text = "Log in ", fontSize = 22.sp)
        }
        Text(
            text = "SIGN UP ",
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 16.dp)
                .clickable {context.startActivity(Intent(context, Dang_Ky::class.java))  }
        )
    }
}


