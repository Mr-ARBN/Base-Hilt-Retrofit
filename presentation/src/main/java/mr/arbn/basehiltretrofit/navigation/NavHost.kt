package mr.arbn.basehiltretrofit.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mr.arbn.basehiltretrofit.TestScreenOne
import mr.arbn.basehiltretrofit.TestScreenThree
import mr.arbn.basehiltretrofit.TestScreenTwo
import kotlinx.serialization.Serializable

@Serializable
object Brand

@Serializable
object Config

@Serializable
object Price

@Composable
fun TestNavHost(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    startDestination: Any
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable<Brand> {
            TestScreenOne(name = "Brand")
        }
        composable<Config> {
            TestScreenTwo(name = "Config")
        }
        composable<Price> {
            TestScreenThree(name = "Price")
        }
    }
}