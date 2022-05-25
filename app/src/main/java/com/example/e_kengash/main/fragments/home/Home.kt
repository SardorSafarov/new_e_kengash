package com.example.e_kengash.main.fragments.home


import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.more.activities.ActivitiesAdapter
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentHomeBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.moreInActivity.activities.main.ActivitiesAbout
import com.example.e_kengash.main.activity.search.SearchActivity
import com.example.e_kengash.main.activity.strem.LiveSteamActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.more.activites.about.Recommended
import com.example.e_kengash.network.entity.more.activites.all.New
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.tosatLong


class Home : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    ActivitiesAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapter: ActivitiesAdapter by lazy {
        ActivitiesAdapter(
            this,
            requireContext(),
            sharePereferenseHelper.getAccessDomen2()
        )
    }

    override fun onViewCreate() {
        setUi()
        mainFragments()
        getNiewsList()
        getDomen()
        binding.searchView.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }
    }

    private fun getDomen() {
        moreViewModel.getDomen {
            when (it.isSuccessful) {
                true -> {
                    sharePereferenseHelper.setAccessDomen1(it.body()!!.domen)
                    sharePereferenseHelper.setAccessDomen2(it.body()!!.domen_media)
                }
            }
        }
    }

    private fun getNiewsList() {
        moreViewModel.activitesAllList {
            when (it.isSuccessful) {
                true -> {
                    onResponse(it.body()!!.news)
                }
                else -> {
                    binding.progressBar.gone()
                    tosatLong(requireContext(), "Serverda xatolik!!")
                    D("ActivitiesAll activitesAllList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(news: List<New>) {
        binding.apply {
            progressBar.gone()
            recNews.layoutManager = LinearLayoutManager(requireContext())
            recNews.adapter = adapter
        }
        adapter.setData(news)
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
        val view =
            LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog_sign_up, null)
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
    override fun itemSetOnClickLister(id: String) {
        moreViewModel.activitesAbout(id) {
            when (it.isSuccessful) {
                true -> {
                    activitesAbout(it.body()!!.news,it.body()!!.recommended)
                }
                else -> {
                    tosatLong(requireContext(), "Serverda xatolik!!")
                    D("ActivitiesAll activitesAbout ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun activitesAbout(
        news: List<com.example.e_kengash.network.entity.more.activites.about.New>,
        recommended: List<Recommended>
    ) {
        val intent = Intent(requireContext(), ActivitiesAbout::class.java)
        intent.apply {
            news[0].apply {
                putExtra("id", id.toString())
                putExtra("content", content)
                putExtra("image", sharePereferenseHelper.getAccessDomen2().plus(image))
                putExtra("title", title)
                putExtra("date", date)
            }
        }
        startActivity(intent)
    }
}