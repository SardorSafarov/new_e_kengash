package com.example.e_kengash.main.activity.moreInActivity.council.fragment.councilDeputat

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.council.changeDeputat.ChangeDeputatDocAdapter
import com.example.e_kengash.databinding.FragmentCouncilDeputatDocumentBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.ChangeDeputatDocResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.Document
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong


class CouncilDeputatDocument :
    MoreBaseFragment<FragmentCouncilDeputatDocumentBinding>(FragmentCouncilDeputatDocumentBinding::inflate),
    ChangeDeputatDocAdapter.onClickListener {
    private val adapter: ChangeDeputatDocAdapter by lazy { ChangeDeputatDocAdapter(this) }

    override fun onViewCreate() {
        councilViewModel.changeDeputatDoc(sharePereferenseHelper.getAccessDeputatId()) {
            when (it.isSuccessful) {
                true -> {
                    binding.progressBar.invisible()
                    when (it.body() is ChangeDeputatDocResponse) {
                        true -> {
                            val data = it.body() as ChangeDeputatDocResponse
                            onResponse(data.documents)
                        }
                        else -> {
                            tosatLong(requireContext(), "Deputatga aloqador hujjatlar mavjud emas")
                        }
                    }
                    // onResponse(it.body()!!.documents)
                }
                else -> {
                    binding.progressBar.invisible()
                    D(
                        "CouncilDeputatDocument changeDeputatDoc false ".plus(
                            it.errorBody()!!.string()
                        )
                    )
                }
            }
        }
    }


    private fun onResponse(documents: List<Document>) {
        binding.apply {
            progressBar.invisible()
            recList.adapter = adapter
            recList.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setData(documents)
    }

    override fun setOnClickLister(url: String) {
        val request =
            DownloadManager.Request(Uri.parse(sharePereferenseHelper.getAccessDomen1().plus(url)))
                .setTitle("File")
                .setDescription("Yuklanmoqda...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setAllowedOverMetered(true)
        val dm = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }

}