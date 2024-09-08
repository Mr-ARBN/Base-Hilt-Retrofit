package com.example.basehiltretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.basehiltretrofit.navigation.FriendsList
import com.example.basehiltretrofit.navigation.Profile
import com.example.basehiltretrofit.navigation.Settings
import com.example.basehiltretrofit.navigation.TestNavHost
import com.example.basehiltretrofit.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var selectedItem by rememberSaveable { mutableIntStateOf(0) }
            val items = listOf("Profile", "FriendList", "Setting")
            val icons =
                listOf(Icons.Outlined.Person, Icons.Outlined.AccountBox, Icons.Outlined.Settings)
            val iconSelected =
                listOf(Icons.Filled.Person, Icons.Filled.AccountBox, Icons.Filled.Settings)

            MyApplicationTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBar(modifier = Modifier.fillMaxWidth()) {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItem == index,
                                    icon = {
                                        Icon(
                                            imageVector = if (selectedItem == index) iconSelected[index] else icons[index],
                                            contentDescription = ""
                                        )
                                    },
                                    label = {
                                        Text(text = item)
                                    },
                                    onClick = {
                                        when (index) {
                                            0 -> navController.navigate(Profile)
                                            1 -> navController.navigate(FriendsList)
                                            2 -> navController.navigate(Settings)
                                        }
                                        selectedItem = index
                                    })
                            }

                            /*listOf("Profile", "FriendList", "Setting").forEach {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            when (it) {
                                                "Profile" -> navController.navigate(Profile)
                                                "FriendList" -> navController.navigate(FriendsList)
                                                "Setting" -> navController.navigate(Settings)
                                            }
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

//                            Image(imageVector = icon, contentDescription = "")
                                    Text(text = it)
                                }
                            }*/

                        }
                    }) {
                    TestNavHost(
                        navHostController = navController,
                        startDestination = Profile
                    )
                }
            }
        }
    }
}