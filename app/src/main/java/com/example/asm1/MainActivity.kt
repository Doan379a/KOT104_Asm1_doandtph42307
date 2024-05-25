package com.example.asm1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String, val icon: Int) {
    object Home : Screen("home", R.drawable.home)
    object History : Screen("history", R.drawable.v2)
    object Cart : Screen("cart", R.drawable.bell)
    object Profile : Screen("profile", R.drawable.pe)
}

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
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
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomTab(navController = navController)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
fun BottomTab(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.History,
        Screen.Cart,
        Screen.Profile
    )

    val selectedIndex = remember { mutableStateOf(0) } // Theo dõi chỉ mục được chọn
    val iconSize = 25.dp
    val iconPadding = 8.dp
    NavigationBar(
        containerColor = Color.White, // Đặt màu nền hộp chứa thành màu trắng
        contentColor = Color.Transparent, // Đặt màu nội dung theo màu mong muốn của bạn
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent)
                .padding(horizontal = 20.dp, vertical = 10.dp), // Fill the width of the parent
            horizontalArrangement = Arrangement.SpaceAround, // Evenly distribute items
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEachIndexed { index, screen ->
                val isSelected = selectedIndex.value == index
                val backgroundColor =
                    if (isSelected) Color.Transparent else Color.Transparent // Màu nền khi được chọn và không được chọn
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp)) // Bo góc 10dp
                        .background(backgroundColor) // Áp dụng màu nền
                        .padding(iconPadding) // Padding bên trong mục để tạo khoảng cách
                        .clickable {
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                            selectedIndex.value = index // Cập nhật chỉ mục được chọn khi nhấp
                        }
                        .weight(1f), // Each item occupies equal space
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null,
                        modifier = Modifier.size(iconSize), // Tăng kích thước biểu tượng lên 40dp
                        tint = if (isSelected) Color.Black else Color.Gray // Đặt màu cho biểu tượng dựa trên chỉ mục được chọn
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        // tùy vào route object nào sẽ navigate đến fun component đó
        composable(Screen.Home.route) { LOTrang_Chu() }
        composable(Screen.History.route) { LOYeu_Thich() }
        composable(Screen.Cart.route) { LOTong_Bao() }
        composable(Screen.Profile.route) { LOProfile() } // Thêm LOProfile vào NavHost
    }
}

//////

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Giỏ hàng", style = MaterialTheme.typography.titleSmall)
    }
}

