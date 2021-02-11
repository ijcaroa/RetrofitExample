package com.example.retrofitexample.remote

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

//Crear data class para representar las fotos, representa un objeto de la lista.
// Se debe tener claro que es lo que llegará, en este caso es un listado []
//rEPRESENTACIÓN DE LA CLASE DE LO QUE LLEGARÁ

@Entity (tableName = "mars_table")
data class MarsRealState(
                        @SerializedName("id")
                        @PrimaryKey
                        @NotNull
                        val id: String,
                        @SerializedName("price")
                         val price: Long,
                        @SerializedName("type")
                        val type: String,
                        @SerializedName("img_src") //Sirve para igualar mi nombre con el original de internet
                        val imgSrc: String)
