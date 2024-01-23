package com.example.livechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.rememberNavController
import com.example.livechat.Screen.LoginScreen
import com.example.livechat.ui.theme.LivechatTheme
import dagger.hilt.android.lifecycle.HiltViewModel


sealed class DestinationScreen(var route: String){
    object  SignUp : DestinationScreen("SignUp")
    object  Login : DestinationScreen("login")
    object  Profile : DestinationScreen("profile")
    object  ChatList : DestinationScreen("ChatList")
    object  SingleChat: DestinationScreen("singleChat/{chatId}"){
        fun createRoute(id :String) ="singleChat/$id"
    }
    object  StatusList : DestinationScreen("StatusList")
    object  SingleStatus: DestinationScreen("singleStatus/{userId}") {
        fun createRoute(id: String) = "singleStatus/$id"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LivechatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  ChatAppNavigation()
                }
            }

        }
    }
}
       @Composable
       fun ChatAppNavigation() {

           val navController= rememberNavController()
           var vm = HiltViewModel <LCViewModel> ()
           NavHost(navController = navController,startDestination =  DestinationScreen.SignUp.route) {
               Composable(DestinationScreen.SignUp.route)
               SinUpScreen(navController)

           }
           Composable(DestinationScreen.Login.route)
               LogloinScreen()

}


}
