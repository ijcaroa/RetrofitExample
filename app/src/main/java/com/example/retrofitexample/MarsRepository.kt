package com.example.retrofitexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample.model.MarsDao
import com.example.retrofitexample.remote.MarsRealState
import com.example.retrofitexample.remote.RetrofitClient

class MarsRepository (private val marsDao: MarsDao){
        private val retrofitClient = RetrofitClient.getRetrofit()
        var dataFromInternet = MutableLiveData<List<MarsRealState>>()
    /*fun fetchDataMars(): LiveData<List<MarsRealState>>{  //Forma antigua
        Log.d("REPO","vieja confiable")
        retrofitClient.fetchMarsData().enqueue(object : Callback<List<MarsRealState>> {
            //el onresponse y el onfailure se deben crear una vez creado el retrofitclient
            override fun onResponse(
                call: Call<List<MarsRealState>>,
                response: Response<List<MarsRealState>>
            ) {
                when(response.code()) {
                    in 200..299 -> dataFromInternet.value = response.body()
                    in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                    else -> Log.d("REPO","${response.code()} --- ${response.errorBody().toString()}")
                }
            }

            override fun onFailure(call: Call<List<MarsRealState>>, t: Throwable) {
                Log.e("REPO","${t.message}")
            }
        })
    return dataFromInternet
    }*/
    //try catch manejo de excepciones. Obtener datos con coroutines. Esta es la forma nueva
    suspend fun  fetchDataFromInternetCoroutines() {
        try{
            val response = retrofitClient.fetchmarsDataCoroutine()
            when(response.code()) {
                in 200..299 -> response.body()?.let { marsDao.insertAllTask(it) }
                in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO","${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable){
            Log.e("REPO","${t.message}")
        }

    }
    val listAlltask : LiveData<List<MarsRealState>> = marsDao.getAllTask()

    suspend fun insertTask(task: MarsRealState){
        marsDao.insertTask(task)
    }
    suspend fun updateTask(task: MarsRealState){
        marsDao.updateTask(task)
    }
    suspend fun deleteAll(){
        marsDao.deleteAll()
    }

    fun getTaskById(id: String): LiveData<MarsRealState> {
        return marsDao.getTaskById(id)
    }

}