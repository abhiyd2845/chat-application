package com.example.livechat.ui.theme

import androidx.navigation.NavController
import java.net.NoRouteToHostException

fun navigateTo(navController: NavController,route: String){
    navController.navigate(route){
        popUpTo(route)
        launchSingleTop=true
    }
}
