package com.example.e_kengash.main.fragments.home


import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.article.ArticleAdapter
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentHomeBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.strem.LiveSteamActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.more.article.New
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone


class Home :  BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),ArticleAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapterArticle:ArticleAdapter by lazy { ArticleAdapter(this) }
    override fun onViewCreate() {
        setUi()
        mainFragments()
        getNiewsList()
    }

    private fun getNiewsList() {
        moreViewModel.newsList()
        moreViewModel.newsList.observe(this, Observer {
            if(it.isSuccessful){
                binding.progressBar.gone()
                onResponse(it.body()!!.news)
            }
            else{
                D("Home newsList false ${it.errorBody()!!.string()}")
            }
        })
    }

    private fun onResponse(body: List<New>) {
        binding.recNews.apply {
            adapter = adapterArticle
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterArticle.setData(body)
    }

    private fun mainFragments() {
        binding.apply {
            chat.setOnClickListener {
                navController.navigate(R.id.chatFragment)
            }
            live.setOnClickListener {
                startActivity(Intent(requireContext(), LiveSteamActivity::class.java))
            }
            appleas.setOnClickListener {
                when (sharePereferenseHelper.getAccessToken()) {
                    "empty" -> {
                        signUp()
                    }
                    else -> {
                        navController.navigate(R.id.appealsFragment)
                    }
                }

            }
            neww.setOnClickListener {
                when (sharePereferenseHelper.getAccessToken()) {
                    "empty" -> {
                        signUp()
                    }
                    else -> {
                        navController.navigate(R.id.appealsSendFragment)
                    }
                }

            }
        }
    }
    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(requireContext(), R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }
    private fun setUi() {
        val articleRepository = MoreRepository()
        val articleViewModelFactory = MoreViewModelFactory(articleRepository)
        val articleViewModel = ViewModelProvider(
            this,
            articleViewModelFactory
        ).get(MoreViewModel::class.java)
        this.moreViewModel = articleViewModel

    }

    override fun setOnClickLister(text: String) {

    }
}