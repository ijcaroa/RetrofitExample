package com.example.retrofitexample.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

//Segundo paso. crear interface. aca se ponen las operaciones o peticiones
interface MarsAPI {
    @GET("realestate")
    //Crear metodo que realice la acción. Poner Internface call de retrofit
    //Se pueden agregar mas metodos como POST
    fun fetchMarsData(): Call<List<MarsRealState>> //Forma antigua

    @GET("realestate")
    suspend fun fetchmarsDataCoroutine()
    : Response<List<MarsRealState>> // nueva forma




}