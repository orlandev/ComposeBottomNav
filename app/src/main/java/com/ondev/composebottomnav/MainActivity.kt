package com.ondev.composebottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ondev.composebottomnav.ui.theme.ComposeBottomNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {

    val floatButtonDocked = remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {
                Text(text = "Compose Bottom Nav")
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Text(
                    text = "TEXT VALUE",
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    floatButtonDocked.value = !floatButtonDocked.value
                },
                shape = RoundedCornerShape(50),
            ) {
                Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
            }
        },
        isFloatingActionButtonDocked = floatButtonDocked.value,
        floatingActionButtonPosition = FabPosition.End, //if its not set, it's show default position

        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = true,
                            onClick = {

                            },
                            icon = {
                                Icon(Icons.Filled.Home, contentDescription = "home")
                            },
                            label = { Text(text = "Home") },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            selected = false,
                            onClick = {

                            },
                            icon = {
                                Icon(Icons.Filled.Settings, contentDescription = "setting")
                            },
                            label = { Text(text = "Setting") },
                            alwaysShowLabel = false
                        )
                    }
                }

            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBottomNavTheme {
        App()
    }
}