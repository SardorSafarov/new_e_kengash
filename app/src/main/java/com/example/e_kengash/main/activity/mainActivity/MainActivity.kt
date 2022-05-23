package com.example.e_kengash.main.activity.mainActivity

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityMainBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class MainActivity : AppCompatActivity() {
    //*======لا اله الا الله محمد رسول الله

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        navController = findNavController(R.id.main_nav_fragment)
        setupWithNavController(binding.bottomNavigationView, navController)
        sharePereferenseHelper = SharePereferenseHelper(this)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment ->{
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.appealsFragment->{
                    when (sharePereferenseHelper.getAccessToken()) {
                        "empty" -> {
                            it.setCheckable(false)
                            it.setChecked(false)
                            signUp()
                        }
                        else -> {
                            navController.navigate(R.id.appealsFragment)
                        }
                    }
                    true
                }
                R.id.appealsSendFragment ->{
                    when (sharePereferenseHelper.getAccessToken()) {
                        "empty" -> {
                            it.setCheckable(false)
                            it.setChecked(false)
                            signUp()
                        }
                        else -> {
                            navController.navigate(R.id.appealsSendFragment)
                        }
                    }
                    true
                }
                R.id.chatFragment ->{
                    navController.navigate(R.id.chatFragment)
                    true
                }
                R.id.moreFragment ->{
                    navController.navigate(R.id.moreFragment)
                    true
                }
                else->{
                    true
                }
            }
        }
        notification()
    }
    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(this, R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }
    private fun notification() {
        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
    }
}