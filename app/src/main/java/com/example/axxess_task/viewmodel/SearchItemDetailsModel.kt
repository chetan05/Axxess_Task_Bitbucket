package com.example.axxess_task.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.axxess_task.model.SearchItemDetailsResponse
import com.example.axxess_task.mvvm.BaseViewModel
import com.example.axxess_task.repositories.local.LocalRepository
import com.example.axxess_task.view.SearchItemDetails
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

open class SearchItemDetailsModel (
):BaseViewModel(){

    var liveSearchItemDetailsResponse = SearchItemDetailsResponse()
    val searchItemDetailsResponse: SearchItemDetailsResponse
        get() = liveSearchItemDetailsResponse

      fun loadDataFromDB() {
        if (SearchItemDetails.roomDB.isOpen) {
            try {
                viewModelScope.launch {
                    LocalRepository.getSearchItemDetailsResponse.collect {
                       liveSearchItemDetailsResponse = it
                    }
                }

            } catch (e: Exception) {
                // not handling
            }
        }
    }

}