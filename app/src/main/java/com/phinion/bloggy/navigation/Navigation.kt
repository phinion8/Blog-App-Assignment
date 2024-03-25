package com.phinion.bloggy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.phinion.bloggy.ui.screens.blog_detail.BlogDetailScreen
import com.phinion.bloggy.ui.screens.home.HomeScreen
import com.phinion.bloggy.ui.screens.onboarding.OnBoardingScreen
import com.phinion.bloggy.ui.screens.onboarding.viewmodel.OnBoardingViewModel
import com.phinion.bloggy.ui.screens.profile.ProfileScreen
import com.phinion.bloggy.ui.screens.splash.SplashScreen
import com.phinion.bloggy.ui.screens.splash.viewmodel.SplashViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun SetUpNavigation(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel(),
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
    showBottomBar: (Boolean) -> Unit
) {

    val onBoardingCompleted by splashViewModel.onBoardingState.collectAsState()

    NavHost(navController = navController, startDestination = Screens.Splash.route) {

        composable(route = Screens.Splash.route) {
            showBottomBar(false)
            SplashScreen(
                onSplashComplete = {
                    if (onBoardingCompleted)
                        navController.navigate(Screens.Home.route)
                    else
                        navController.navigate(Screens.OnBoarding.route)
                }
            )
        }

        composable(route = Screens.OnBoarding.route) {
            showBottomBar(false)
            OnBoardingScreen(onFinishedClick = {
                onBoardingViewModel.saveOnBoardingState(completed = true)
                navController.navigate(Screens.Home.route)
            })

        }

        composable(route = Screens.Home.route) {
            showBottomBar(true)
            HomeScreen(navController = navController, onBlogItemClick = { url ->
                navController.navigate(Screens.BlogDetail.createRoute(url))
            })
        }

        composable(route = Screens.BlogDetail.route, arguments = listOf(
            navArgument(Routes.KEY_BLOG_URL) {
                NavType.StringType
            }
        )) { navBackStackEntry ->
            val blogUrl = navBackStackEntry.arguments?.getString(Routes.KEY_BLOG_URL)
            if (blogUrl != null) {
                BlogDetailScreen(blogUrl = blogUrl)
            }
        }

        composable(route = Screens.Profile.route) {
            ProfileScreen()
        }

    }

}