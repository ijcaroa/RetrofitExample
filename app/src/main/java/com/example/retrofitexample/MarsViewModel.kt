package com.example.retrofitexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.model.MarsDataBase
import com.example.retrofitexample.remote.MarsRealState
import kotlinx.coroutines.launch

class MarsViewModel(application: Application) : AndroidViewModel(application){

    private val repository: MarsRepository
    lateinit var livedataFronInternet: LiveData<List<MarsRealState>>
    val allTask : LiveData<List<MarsRealState>>

    init {
        val MarsDao = MarsDataBase.getDataBase(application).getMarsDao()
        repository = MarsRepository(MarsDao)
        viewModelScope.launch {
            repository.fetchDataFromInternetCoroutines()
        }

        allTask = repository.listAlltask

    }
    fun insertTask(task: MarsRealState) = viewModelScope.launch {
        repository.insertTask(task)
    }
    fun updateTask(task: MarsRealState) = viewModelScope.launch {
        repository.updateTask(task)
    }
    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
    fun getTaskById (id: String): LiveData<MarsRealState> {
        return repository.getTaskById(id)
    }
   /* init {
        repository = MarsRepository()
        livedataFronInternet = repository.fetchDataMars()
    }
*/

}