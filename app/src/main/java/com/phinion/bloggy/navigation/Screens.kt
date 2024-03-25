package com.phinion.bloggy.navigation

sealed class Screens(val route: String){
    data object Splash: Screens(route = Routes.SPLASH_SCREEN)
    data object OnBoarding: Screens(route = Routes.ONBOARDING_SCREEN)
    data object Home: Screens(route = Routes.HOME_SCREEN)
    data object BlogDetail: Screens(route = Routes.BLOG_DETAIL_SCREEN){
        fun createRoute(blogUrl: String): String{
            return "blog_detail_screen/${blogUrl}"
        }
    }
    data object Profile: Screens(route = Routes.PROFILE_SCREEN)
}