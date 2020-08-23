package com.example.axxess_task.repositories.local


import com.example.axxess_task.model.SearchItemDetailsResponse
import com.example.axxess_task.view.SearchItemDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

object LocalRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    val getSearchItemDetailsResponse: Flow<SearchItemDetailsResponse>
        get() = SearchItemDetails.roomDB.roomDao().getSearchItemDetailsResponse()

    suspend fun addSearchItemDetailsResponse(tr: SearchItemDetailsResponse) =
        SearchItemDetails.roomDB.roomDao().addSearchItemDetailsResponse(tr)
}