package com.example.livechat

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LCApplication @Inject constructor(
    val auth :
): ViewModel (){


    fun  signUP(name:String,email:String,password:String){
     auth.createUserWithemailAndPassword(email,password).addOnCompleteLstener{

         if (it isSuccessful){
             Log.d(TAG, "signUP: ")

         }
     }

    }
}