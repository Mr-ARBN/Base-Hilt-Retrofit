package com.example.basehiltretrofit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.basehiltretrofit.TestScreenOne
import com.example.basehiltretrofit.TestScreenThree
import com.example.basehiltretrofit.TestScreenTwo
import kotlinx.serialization.Serializable

@Serializable
object Profile
@Serializable
object FriendsList
@Serializable
object Settings

@Composable
fun TestNavHost(
    navHostController: NavHostController,
    startDestination: Any
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable<Profile> {
            TestScreenOne(name = "Profile")
        }
        composable<FriendsList> {
            TestScreenTwo(name = "FriendsList")
        }
        composable<Settings> {
            TestScreenThree(name = "Settings")
        }
    }
}