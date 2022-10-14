package com.example.e_kengash.main.activity.moreInActivity.document.main

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.more.document.DocumentAdapter
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityDocumentBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.login.webView.LoginWebActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.network.entity.more.document.LawDecision
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatLong

class DocumentActivity : AppCompatActivity(),DocumentAdapter.ItemClick {

    private lateinit var binding:ActivityDocumentBinding
    private val adapter:DocumentAdapter by lazy { DocumentAdapter(this) }
    private lateinit var sharePereferenseHelper:SharePereferenseHelper
    lateinit var moreViewModel: MoreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        statusbarcolor(Color.WHITE)
        moreSetUi()
        back()
        notification()
        getDocumentList()
        documentSearch()
    }

    private fun documentSearch() {
        binding.search.setOnClickListener {
            startActivity(Intent(this,DocumentSearchActivity::class.java))
        }
    }

    private fun getDocumentList() {
        moreViewModel.getDocumentList {
            when(it.isSuccessful)
            {
                true->{
                  docAdapterSetData(it.body()!!.LawDecision)
                }
                else->{
                    tosatLong(this,"Serverda xatolik!!")
                    D("DocumentActivity getDocumentList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun docAdapterSetData(lawDecision: List<LawDecision>) {
            binding.apply {
                progressBar.invisible()
                recList.apply {
                    adapter = this@DocumentActivity.adapter
                    layoutManager =LinearLayoutManager(this@DocumentActivity)
                }
            }
        adapter.setData(lawDecision)
    }

    private fun moreSetUi() {
        val moreRepository = MoreRepository()
        val moreVewModelFactory = MoreViewModelFactory(moreRepository)
        val moreViewModel = ViewModelProvider(
            this,
            moreVewModelFactory
        ).get(MoreViewModel::class.java)
        this.moreViewModel = moreViewModel
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            when ( sharePereferenseHelper.getAccessToken()) {
                "empty" -> {
                    signUp()
                }
                else -> {
                    startActivity(Intent(this, NotificationActivity::class.java))
                }
            }
        }
    }

    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(this, R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(this, LoginWebActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    override fun itemSetOnClickListener(url: String) {
        val request =
            DownloadManager.Request(Uri.parse(sharePereferenseHelper.getAccessDomen2().plus(url)))
                .setTitle("File")
                .setDescription("Yuklanmoqda...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setAllowedOverMetered(true)
        val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }
}