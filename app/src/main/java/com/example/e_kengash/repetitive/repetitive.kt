package com.example.e_kengash.repetitive

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
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
fun RequestLog(message: String, s: String){
    Log.d("request","====================================================")
    Log.d("request","log ===>  $s  <===log")
    Log.d("request","log ===>  $message  <===log")
    Log.d("request","====================================================")
}

fun View.gone():View
{
    visibility = View.GONE
    return this
}

fun View.visible():View
{
    visibility = View.VISIBLE
    return this
}

fun View.invisible():View
{
    visibility = View.INVISIBLE
    return this
}