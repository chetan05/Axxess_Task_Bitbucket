package com.example.axxess_task.network
import com.example.axxess_task.model.SearchResultResponse
import retrofit2.Response
import retrofit2.http.Query

interface APIService {
    @retrofit2.http.GET("search/1")
    suspend fun getSearchResult(
        @retrofit2.http.Header("Authorization") token: String,
        @Query("q") query: String
    ): Response<SearchResultResponse>
}
