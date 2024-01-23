package com.example.livechat.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.livechat.DestinationScreen
import com.example.livechat.LCViewModel
import com.example.livechat.R
import com.example.livechat.ui.theme.navigateTo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController, vm :LCViewModel) {

      Box(modifier = Modifier.fillMaxSize()) {
          Column (modifier = Modifier
              .fillMaxSize()
              .wrapContentHeight()
              .verticalScroll(
                  rememberScrollState()
              )) {
              val nameState= remember {
                 mutableStateOf(TextFieldValue())}
                  val numberState= remember {
                      mutableStateOf(TextFieldValue())}
                      val emailState= remember {
                          mutableStateOf(TextFieldValue())}
                          val passwordState= remember {
                              mutableStateOf(TextFieldValue())}
              }
         val focus= LocalFocusManager.current
Image(painter =
      painterResource(id = R.drawable.chat), contentDescription = null,
              modifier = Modifier
                  .width(200.dp)
                  .padding(top = 16.dp)
                  .padding(8.dp))

      Text(text = "Signup",
          fontSize = 30.sp,
          fontFamily = FontFamily.SansSerif,
          fontWeight = FontWeight.Bold,
          modifier= Modifier.padding(8.dp)
      )
      OutlinedTextField(value = nameState.value,
          onValueChange = {
          nameState.value = it
          },
          label = { Text(text = "name")},
          modifier = Modifier.padding(8.dp)
      
        )
          OutlinedTextField(value = numberState.value,
              onValueChange = {
                  numberState.value = it
              },
              label = { Text(text = "number")},
              modifier = Modifier.padding(8.dp)

          )
          OutlinedTextField(value = emailState.value,
              onValueChange = {
                  emailState.value = it
              },
              label = { Text(text = "email")},
              modifier = Modifier.padding(8.dp)

          )
          OutlinedTextField(value = passwordState.value,
          onValueChange = {
              passwordState.value = it
          },
          label = { Text(text = "password")},
          modifier = Modifier.padding(8.dp)

          )
            Button(onClick = {vm.SignUp(
                nameState.value.text,
                        numberState.value.text,
                        emailState.value.text,
                        passwordState.value.text,
            ) },

            modifier = Modifier.padding(8.dp)) {
                Text(text = "SIGN UP")
                
            }
          Text(text ="already a User ? Go to login->",
              color = Color.Blue,
              modifier = Modifier.padding(8.dp)
                  .clickable {
                 navigateTo(navController,DestinationScreen.Login.route)
              }
          )
          }

      }
}