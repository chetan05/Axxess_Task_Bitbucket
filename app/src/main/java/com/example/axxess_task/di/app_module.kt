package com.example.axxess_task.di

import com.example.axxess_task.network.API
import com.example.axxess_task.repositories.ApiDataService
import com.example.axxess_task.repositories.MobsterRepository
import com.example.axxess_task.rx.ApplicationSchedulerProvider
import com.example.axxess_task.rx.SchedulerProvider
import com.example.axxess_task.viewmodel.SearchItemDetailsModel
import com.example.axxess_task.viewmodel.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { SearchViewModel(get() as ApiDataService) }

    viewModel { SearchItemDetailsModel() }

    single { MobsterRepository(get()) as ApiDataService }

    single<SchedulerProvider> { ApplicationSchedulerProvider() }

    single { API.apiServices }

}
val app = listOf(appModule)