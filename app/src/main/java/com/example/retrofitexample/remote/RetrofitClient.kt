package com.example.retrofitexample.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// tercer paso
class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

        //Unirse con la interface. devuelve una unica instancia del objeto
        fun getRetrofit(): MarsAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(MarsAPI::class.java)
        }
    }
}
