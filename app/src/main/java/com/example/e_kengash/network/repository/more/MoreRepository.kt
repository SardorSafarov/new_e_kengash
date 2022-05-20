package com.example.e_kengash.network.repository.more

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
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response
import retrofit2.http.Body

class MoreRepository {

    suspend fun getDomen():Response<GetDomenResponse> = RetrofitBuilder().moreApi.getDomen()

    suspend fun articleList():Response<ArticleResponse> = RetrofitBuilder().moreApi.articleList()

    suspend fun newsList():Response<ArticleResponse> = RetrofitBuilder().moreApi.newsList()

     suspend fun secRegionList():Response<SecRegionResponse> = RetrofitBuilder().moreApi.secretariatRegionList()

     suspend fun secDistrictList():Response<SecRegionResponse> = RetrofitBuilder().moreApi.secretariatDistrictList()

    suspend fun secretariatDataList():Response<SecretariatDataListResponse> = RetrofitBuilder().moreApi.secretariatDataList()

    suspend fun secretariatChangeDeputatData(id:String):Response<SecretariatChangeDeputatDataResponse> = RetrofitBuilder().moreApi.secretariatChangeDeputatData(id)

    suspend fun discussionOfferList():Response<DiscussionOfferListResponse> = RetrofitBuilder().moreApi.discussionOfferList()

    suspend fun discussionLike(token: String, id: String):Response<DiscussionLikeDisLikeResponse> = RetrofitBuilder().moreApi.discussionLike(token,id)

    suspend fun discussionDisLike(token: String, id: String):Response<DiscussionLikeDisLikeResponse> = RetrofitBuilder().moreApi.discussionDisLike(token,id)

    suspend fun discussionOfferAbout( id: String):Response<DiscussionOfferAboutResponse> = RetrofitBuilder().moreApi.discussionOfferAbout(id)

    suspend fun discussionOfferComment( id: String):Response<DiscussionOfferCommentsResponse> = RetrofitBuilder().moreApi.discussionOfferComment(id)

    suspend fun discussionOfferCommentAdd(id: String,token:String,body: DiscussionCommentAddRequest):Response<DiscussionCommentAddResponse> = RetrofitBuilder().moreApi.discussionOfferCommentAdd(id,token,body)

    suspend fun activitesAllList():Response<ActivitiesAllResponse> = RetrofitBuilder().moreApi.activitesAllList()

    suspend fun activitesNewsList():Response<ActivitiesAllResponse> = RetrofitBuilder().moreApi.activitesNewsList()
}