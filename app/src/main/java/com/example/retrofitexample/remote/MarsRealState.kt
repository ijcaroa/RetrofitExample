package com.example.retrofitexample.remote

import com.google.gson.annotations.SerializedName

//Crear data class para representar las fotos, representa un objeto de la lista.
// Se debe tener claro que es lo que llegará, en este caso es un listado []

data class MarsRealState(
                        @SerializedName("id")
                        val id: String,
                        @SerializedName("price")
                         val price: Long,
                        @SerializedName("type")
                        val type: String,
                        @SerializedName("img_src") //Sirve para igualar mi nombre con el original de internet
                        val imgSrc: String)
