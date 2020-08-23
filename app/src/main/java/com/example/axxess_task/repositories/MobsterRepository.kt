package com.example.axxess_task.repositories

import com.example.axxess_task.network.APIResult
import com.example.axxess_task.network.APIService
import com.example.axxess_task.model.*

class MobsterRepository(val api: APIService) : BaseRepository(), ApiDataService {
    override suspend fun getSearchResult(idToken: String, query: String): APIResult<SearchResultResponse> =
        getAPIResult(safeApiCall { api.getSearchResult(idToken, query) })
}
