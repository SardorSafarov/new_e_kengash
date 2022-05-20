package com.example.e_kengash.network.api.more

import com.example.e_kengash.network.entity.getDomen.GetDomenResponse
import com.example.e_kengash.network.entity.more.activites.about.ActivitesAboutResponse
import com.example.e_kengash.network.entity.more.activites.all.ActivitiesAllResponse
import com.example.e_kengash.network.entity.more.article.ArticleResponse
import com.example.e_kengash.network.entity.more.discussion.commentAdd.DiscussionCommentAddRequest
import com.example.e_kengash.network.entity.more.discussion.commentAdd.DiscussionCommentAddResponse
import com.example.e_kengash.network.entity.more.discussion.like.DiscussionLikeDisLikeResponse
import com.example.e_kengash.network.entity.more.discussion.offer.DiscussionOfferListResponse
import com.example.e_kengash.network.entity.more.discussion.offerAbout.DiscussionOfferAboutResponse
import com.example.e_kengash.network.entity.more.discussion.offerAbout.comment.DiscussionOfferCommentsResponse
import com.example.e_kengash.network.entity.more.document.DocumentListResponse
import com.example.e_kengash.network.entity.more.secretariat.changeDeputat.SecretariatChangeDeputatDataResponse
import com.example.e_kengash.network.entity.more.secretariat.data.SecretariatDataListResponse
import com.example.e_kengash.network.entity.more.secretariat.region.SecRegionResponse
import retrofit2.Response
import retrofit2.http.*

interface MoreApi {

    @GET("/api/v1/get-domen")
    suspend fun getDomen():Response<GetDomenResponse>

    @GET("/api/v1/articles")
    suspend fun articleList():Response<ArticleResponse>

    @GET("/api/v1/news")
    suspend fun newsList():Response<ArticleResponse>

    /*-----------Secretatiat-----------------------*/
    @GET("/api/v1/secretariat-region")
    suspend fun secretariatRegionList():Response<SecRegionResponse>

    @GET("/api/v1/secretariat-district")
    suspend fun secretariatDistrictList():Response<SecRegionResponse>

    @GET("/api/v1/secretariat-info/")
    suspend fun secretariatDataList():Response<SecretariatDataListResponse>

    @GET("/api/v1/secretariat/{id}/info/")
    suspend fun secretariatChangeDeputatData(@Path("id")id:String):Response<SecretariatChangeDeputatDataResponse>

    /*---------------Discussion------------------*/

    @GET("/api/v1/apppeal-comment/")
    suspend fun discussionOfferList():Response<DiscussionOfferListResponse>

    @POST("/api/v1/appeal-comment/{id}/like/")
    suspend fun discussionLike(@Header("Authorization") token:String,@Path("id")id:String):Response<DiscussionLikeDisLikeResponse>

    @POST("/api/v1/appeal-comment/{id}/dislike/")
    suspend fun discussionDisLike(@Header("Authorization") token:String,@Path("id")id:String):Response<DiscussionLikeDisLikeResponse>

    @GET("/api/v1/appeal/{id}/detail/")
    suspend fun discussionOfferAbout(@Path("id")id:String):Response<DiscussionOfferAboutResponse>

    @GET("/api/v1/appeal-comment/{id}/list/")
    suspend fun discussionOfferComment(@Path("id")id:String):Response<DiscussionOfferCommentsResponse>

    @POST("api/v1/appeal-comment/{id}/add/")
    suspend fun discussionOfferCommentAdd(@Path("id")id:String,@Header("Authorization")token:String,@Body body: DiscussionCommentAddRequest):Response<DiscussionCommentAddResponse>

    /*----------Activities---------------*/

    @GET("/api/v1/events/")
    suspend fun activitesAllList():Response<ActivitiesAllResponse>

    @GET("/api/v1/summits/")
    suspend fun activitesNewsList():Response<ActivitiesAllResponse>

    @GET("api/v1/event/{id}/detail")
    suspend fun activitesAbout(@Path("id")id:String):Response<ActivitesAboutResponse>

    /*---------Document-----------------------*/
    @GET("mobile/mobile_law_decision")
    suspend fun getDocumentList():Response<DocumentListResponse>
}