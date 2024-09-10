package mr.arbn.basehiltretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
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
import mr.arbn.basehiltretrofit.navigation.Brand
import mr.arbn.basehiltretrofit.navigation.Config
import mr.arbn.basehiltretrofit.navigation.Price
import mr.arbn.basehiltretrofit.navigation.TestNavHost
import mr.arbn.basehiltretrofit.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var selectedItem by rememberSaveable { mutableIntStateOf(0) }
            val items = listOf("Brand", "Config", "Price")
            val icons =
                listOf(Icons.Outlined.Menu, Icons.Outlined.Build, Icons.Outlined.ShoppingCart)
            val iconSelected =
                listOf(Icons.Filled.Menu, Icons.Filled.Build, Icons.Filled.ShoppingCart)

            MyApplicationTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBar(modifier = Modifier.fillMaxWidth()) {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItem == index,
                                    icon = {
                                        Icon(
                                            modifier = Modifier,
                                            imageVector = if (selectedItem == index) iconSelected[index] else icons[index],
                                            contentDescription = ""
                                        )
                                    },
                                    label = {
                                        Text(text = item)
                                    },
                                    onClick = {
                                        when (index) {
                                            0 -> navController.navigate(Brand)
                                            1 -> navController.navigate(Config)
                                            2 -> navController.navigate(Price)
                                        }
                                        selectedItem = index
                                    })
                            }
                        }
                    }) { paddingValues ->
                    TestNavHost(
                        paddingValues = paddingValues,
                        navHostController = navController,
                        startDestination = Brand
                    )
                }
            }
        }
    }
}