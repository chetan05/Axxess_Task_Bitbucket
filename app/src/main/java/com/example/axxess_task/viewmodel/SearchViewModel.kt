package com.example.axxess_task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.axxess_task.Util.AUTHORIZATION
import com.example.axxess_task.model.SearchResultResponse
import com.example.axxess_task.mvvm.BaseViewModel
import com.example.axxess_task.network.APIResult
import com.example.axxess_task.repositories.ApiDataService
import com.example.axxess_task.repositories.local.LocalRepository
import com.example.axxess_task.view.SearchItemDetails
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

open class SearchViewModel (
    private val repo: ApiDataService
) : BaseViewModel(){

    val liveSearchResponse = MutableLiveData<SearchResultResponse>()
    val searchResponse: LiveData<SearchResultResponse>
        get() = liveSearchResponse

    private var _searchResponseState = MutableLiveData<ViewModelEvent>().apply {
        value = Uninitialized
    }
    val searchResponseSate: LiveData<ViewModelEvent> get() = _searchResponseState

    fun loadReservation(query: String) {
        showLoading.value = true
        val idToken = AUTHORIZATION
        viewModelScope.launch {
            val result = idToken?.let {repo.getSearchResult(it,query) }
             showLoading.postValue(false)
            when (result) {
                is APIResult.Success -> {
                    liveSearchResponse.value = result.data
                    _searchResponseState.value = Success
                }
                is APIResult.Error -> {
                    _searchResponseState.value = Fail
                }
            }
        }
    }





}