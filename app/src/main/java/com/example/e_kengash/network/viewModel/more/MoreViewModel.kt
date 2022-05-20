package com.example.e_kengash.network.viewModel.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.getDomen.GetDomenResponse
import com.example.e_kengash.network.entity.more.activites.ActivitiesAllResponse
import com.example.e_kengash.network.entity.more.article.ArticleResponse
import com.example.e_kengash.network.entity.more.discussion.commentAdd.DiscussionCommentAddRequest
import com.example.e_kengash.network.entity.more.discussion.commentAdd.DiscussionCommentAddResponse
import com.example.e_kengash.network.entity.more.discussion.like.DiscussionLikeDisLikeResponse
import com.example.e_kengash.network.entity.more.discussion.offer.DiscussionOfferListResponse
import com.example.e_kengash.network.entity.more.discussion.offerAbout.DiscussionOfferAboutResponse
import com.example.e_kengash.network.entity.more.discussion.offerAbout.comment.DiscussionOfferCommentsResponse
import com.example.e_kengash.network.entity.more.secretariat.changeDeputat.SecretariatChangeDeputatDataResponse
import com.example.e_kengash.network.entity.more.secretariat.data.SecretariatDataListResponse
import com.example.e_kengash.network.entity.more.secretariat.region.SecRegionResponse
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class MoreViewModel(private val moreRepository: MoreRepository): ViewModel() {

    fun getDomen(onResponse:(response:Response<GetDomenResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.getDomen())
            }catch (e:Exception)
            {
                D("MoreViewModel getDomen  ${e.message}")
            }
        }
    }

     val articleList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()
     val newsList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()

    fun articleList()
    {
        viewModelScope.launch {
            try {
               articleList.value = moreRepository.articleList()
            }catch (e:Exception)
            {
                D("MoreViewModel articleList  ${e.message}")
            }
        }
    }

    fun newsList()
    {
        viewModelScope.launch {
            try {
                newsList.value = moreRepository.newsList()
            }catch (e:Exception)
            {
                D("MoreViewModel newsList  ${e.message}")
            }
        }
    }

    fun secRegionList(onResponse:(response:Response<SecRegionResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
               onResponse(moreRepository.secRegionList())
            }catch (e:Exception)
            {
                D("MoreViewModel secRegionList  ${e.message}")
            }
        }
    }

    fun secDistrictList(onResponse:(response:Response<SecRegionResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.secDistrictList())
            }catch (e:Exception)
            {
                D("MoreViewModel secDistrictList  ${e.message}")
            }
        }
    }

    fun secretariatDataList(onResponse:(response:Response<SecretariatDataListResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.secretariatDataList())
            }catch (e:Exception)
            {
                D("MoreViewModel secretariatDataList  ${e.message}")
            }
        }
    }

    fun secretariatChangeDeputatData(id:String,onResponse:(response:Response<SecretariatChangeDeputatDataResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.secretariatChangeDeputatData(id))
            }catch (e:Exception)
            {
                D("MoreViewModel secretariatDataList  ${e.message}")
            }
        }
    }

    private val _discussionOfferList = MutableLiveData<Response<DiscussionOfferListResponse>>()
    val discussionOfferList: LiveData<Response<DiscussionOfferListResponse>>
        get() = _discussionOfferList

    fun discussionOfferList()
    {
        viewModelScope.launch {
            try {
              _discussionOfferList.value = moreRepository.discussionOfferList()
            }catch (e:Exception)
            {
                D("MoreViewModel discussionOfferList  ${e.message}")
            }
        }
    }

    fun discussionLike(token:String,id:String,onResponse:(response:Response<DiscussionLikeDisLikeResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.discussionLike(token,id))
            }catch (e:Exception)
            {
                D("MoreViewModel discussionLike  ${e.message}")
            }
        }
    }

    fun discussionDisLike(token:String,id:String,onResponse:(response:Response<DiscussionLikeDisLikeResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.discussionDisLike(token,id))
            }catch (e:Exception)
            {
                D("MoreViewModel discussionDisLike  ${e.message}")
            }
        }
    }

    fun discussionOfferAbout(id:String,onResponse:(response:Response<DiscussionOfferAboutResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.discussionOfferAbout(id))
            }catch (e:Exception)
            {
                D("MoreViewModel discussionOfferAbout  ${e.message}")
            }
        }
    }

    fun discussionOfferComment(id:String,onResponse:(response:Response<DiscussionOfferCommentsResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.discussionOfferComment(id))
            }catch (e:Exception)
            {
                D("MoreViewModel discussionOfferComment  ${e.message}")
            }
        }
    }

    fun discussionOfferCommentAdd(id: String, token:String, body: DiscussionCommentAddRequest, onResponse:(response:Response<DiscussionCommentAddResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.discussionOfferCommentAdd(id,token,body))
            }catch (e:Exception)
            {
                D("MoreViewModel discussionOfferCommentAdd  ${e.message}")
            }
        }
    }

    fun activitesAllList(onResponse:(response:Response<ActivitiesAllResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.activitesAllList())
            }catch (e:Exception)
            {
                D("MoreViewModel activitesAllList  ${e.message}")
            }
        }
    }

    fun activitesNewsList(onResponse:(response:Response<ActivitiesAllResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.activitesNewsList())
            }catch (e:Exception)
            {
                D("MoreViewModel activitesNewsList  ${e.message}")
            }
        }
    }
}