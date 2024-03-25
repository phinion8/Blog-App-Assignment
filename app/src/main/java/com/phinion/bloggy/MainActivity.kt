package com.phinion.bloggy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.phinion.bloggy.navigation.Screens
import com.phinion.bloggy.navigation.SetUpNavigation
import com.phinion.bloggy.ui.components.BottomNavBar
import com.phinion.bloggy.ui.components.models.bottomNavItems
import com.phinion.bloggy.ui.theme.BloggyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloggyTheme {

                val navController = rememberNavController()
                var bottomBarVisibility by remember {
                    mutableStateOf(false)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        content = { paddingValues ->


                            SetUpNavigation(navController = navController, showBottomBar = {
                                bottomBarVisibility = it
                            })


                        },
                        bottomBar = {
                            if (bottomBarVisibility)
                                BottomNavBar(
                                    modifier = Modifier.fillMaxWidth(),
                                    bottomNavItems = bottomNavItems,
                                    navController = navController,
                                    onItemClick = {
                                        navController.navigate(it.route) {
                                            navController.graph.startDestinationRoute?.let { screen_route ->

                                            }
                                            this.launchSingleTop = true
                                            this.restoreState = true
                                        }
                                    }
                                )
                        }
                    )


                }
            }
        }
    }
}


