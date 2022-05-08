package com.example.e_kengash.main.activity.notif

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.notif.NotifAdapter
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityNotificationBinding
import com.example.e_kengash.network.entity.notif.Result
import com.example.e_kengash.network.repository.notif.NotificationRepository
import com.example.e_kengash.network.viewModel.notif.NotifViewModel
import com.example.e_kengash.network.viewModelFactory.notif.NotifViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.statusbarcolor

class NotificationActivity : AppCompatActivity(),NotifAdapter.onClickListener {
    private lateinit var binding:ActivityNotificationBinding
    private lateinit var token:String
    private val adapterNotif:NotifAdapter by lazy { NotifAdapter(this) }
    private lateinit var notifViewModel: NotifViewModel
    private lateinit var  sharePereferenseHelper:SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        token = sharePereferenseHelper.getAccessToken()
        statusbarcolor(Color.WHITE)
        back()
        setUi()
        setDataToAdapter()

    }

    private fun setDataToAdapter() {
        D("Token ".plus(token))
        notifViewModel.notif("Token ".plus(token)) {
            if(it.isSuccessful)
            {
                D(it.body().toString())
               setData(it.body()!!.results)
            }else
            {
                D("NotificationActivity notif  ${it.errorBody()!!.string()}  ")
            }
        }
    }

    private fun setData(results: List<Result>) {
        binding.recNotif.apply {
            adapter = adapterNotif
            layoutManager = LinearLayoutManager(this@NotificationActivity)
        }
        adapterNotif.setData(results)
    }

    private fun setUi() {
        val notificationRepository = NotificationRepository()
        val notifViewModelFactory = NotifViewModelFactory(notificationRepository)
        val notifViewModel = ViewModelProvider(
            this,
            notifViewModelFactory
        ).get(NotifViewModel::class.java)
        this.notifViewModel = notifViewModel

    }
    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    override fun setOnClickLister(text: String) {

    }
}