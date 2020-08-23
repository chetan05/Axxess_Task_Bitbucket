package com.example.axxess_task.viewmodel

open class ViewModelEvent

object Uninitialized: ViewModelEvent()

object Loading : ViewModelEvent()

object Fail : ViewModelEvent()

object Success : ViewModelEvent()