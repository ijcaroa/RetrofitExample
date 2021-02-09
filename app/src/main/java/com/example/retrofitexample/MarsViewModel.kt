package com.example.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.remote.MarsRealState

class MarsViewModel : ViewModel(){
    private val repository: MarsRepository
    val livedataFronInternet: LiveData<List<MarsRealState>>

    init {
        repository=MarsRepository()
        livedataFronInternet = repository.fetchDataMars()
    }
}