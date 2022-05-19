package com.example.e_kengash.main.activity.moreInActivity.discussion.main

import android.app.backup.SharedPreferencesBackupHelper
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.e_kengash.adapter.more.discussion.DiscussionCommentAdapter
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityDiscussionDiscriptionAboutBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.network.entity.more.discussion.commentAdd.DiscussionCommentAddRequest
import com.example.e_kengash.network.entity.more.discussion.offerAbout.comment.Result
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatLong

class DiscussionDiscriptionAbout : AppCompatActivity() {
    lateinit var moreViewModel: MoreViewModel
    private val adapterComment:DiscussionCommentAdapter by lazy { DiscussionCommentAdapter() }
    private lateinit var binding: ActivityDiscussionDiscriptionAboutBinding
    private lateinit var sharedPreferences:SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscussionDiscriptionAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = SharePereferenseHelper(this)
        statusbarcolor(Color.WHITE)
        moreSetUi()
        back()
        notification()
        binding.apply {
            intent.apply {
                user.text = getStringExtra("user")
                modifiedDate.text = getStringExtra("modified_date")
                Glide.with(applicationContext).load(getStringExtra("user_image")).into(userImage)
                direction.text = getStringExtra("direction")
                status.text = getStringExtra("status")
                title.text = getStringExtra("title")
                content.text = getStringExtra("content")
                views.text = getStringExtra("views")
                like.text = getStringExtra("like")
                dislike.text = getStringExtra("dislike")
            }
            btnSendComment.setOnClickListener {
                sendComment()
            }
        }
        moreViewModel.discussionOfferComment(intent.getStringExtra("id").toString()) {
            when (it.isSuccessful) {
                true -> {
                    binding.commentCount.text = it.body()!!.count.toString()
                    adapterComment(it.body()!!.results)
                }
                else -> {
                    tosatLong(this, "Serverda xatolik!!")
                    D(
                        "DiscussionDiscriptionAbout discussionOfferComment ".plus(
                            it.errorBody()!!.string()
                        )
                    )
                }
            }
        }

    }

    private fun sendComment() {
        binding.apply {
            when(commentText.text.toString().trim()!="")
            {
                true->{
                    val c= commentText.text.toString()
                    commentText.text.clear()
                    moreViewModel.discussionOfferCommentAdd(intent.getStringExtra("id").toString(),sharedPreferences.getAccessToken(),
                        DiscussionCommentAddRequest(content = c)
                    )
                    {
                        when(it.isSuccessful)
                        {
                            true->{
                                D(it.body()!!.toString())
                            }
                            else->{
                                D(it.errorBody()!!.string())
                            }
                        }
                    }
                }
                else->{
                    tosatLong(applicationContext,"Izoh yozing!!")
                }
            }
        }
    }

    private fun adapterComment(results: List<Result>) {
            binding.apply {
                recListComment.layoutManager = LinearLayoutManager(applicationContext)
                recListComment.adapter = adapterComment
            }
        adapterComment.setData(results)
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
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
}