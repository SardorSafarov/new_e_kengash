package com.example.e_kengash.repetitive

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast

fun tosatShort(context:Context,message:String)
{
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Activity.statusbarcolor(color: Int)
{
   window.statusBarColor = color
}

fun D(message: String){
    Log.d("sardor","log ===>  $message  <===log")
}