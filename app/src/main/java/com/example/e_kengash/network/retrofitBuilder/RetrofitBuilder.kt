package com.example.e_kengash.network.retrofitBuilder

import com.example.e_kengash.data.constants.Constants.BASE_URL
import com.example.e_kengash.network.api.appealsSend.AppealsSendApi
import com.example.e_kengash.network.api.chat.ChatApi
import com.example.e_kengash.network.api.login.LoginApi
import com.example.e_kengash.network.api.more.MoreApi
import com.example.e_kengash.network.api.more.concil.CouncilApi
import com.example.e_kengash.network.api.more.senatorAndDeputat.SenatorApi
import com.example.e_kengash.network.api.more.youth.YouthApi
import com.example.e_kengash.network.api.notif.NotificationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    val notificationApi:NotificationApi by lazy {
        retrofit.create(NotificationApi::class.java)
    }

    val moreApi: MoreApi by lazy {
        retrofit.create(MoreApi::class.java)
    }

    val appealsSendApi: AppealsSendApi by lazy {
        retrofit.create(AppealsSendApi::class.java)
    }

    val councilApi: CouncilApi by lazy {
        retrofit.create(CouncilApi::class.java)
    }

    val youthApi: YouthApi by lazy {
        retrofit.create(YouthApi::class.java)
    }

    val senatorApi: SenatorApi by lazy {
        retrofit.create(SenatorApi::class.java)
    }

    val chatApi: ChatApi by lazy {
        retrofit.create(ChatApi::class.java)
    }
}