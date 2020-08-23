package com.example.axxess_task.repositories


import com.example.axxess_task.model.SearchResultResponse
import com.example.axxess_task.network.APIResult

interface ApiDataService {
    suspend fun getSearchResult(idToken: String,query:String): APIResult<SearchResultResponse>
}
