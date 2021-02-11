package com.example.retrofitexample.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.retrofitexample.remote.MarsRealState


@Dao
interface MarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask (task: MarsRealState)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTask(ListTask: List<MarsRealState>)

    @Update
    suspend fun updateTask(task: MarsRealState)

    @Delete
    suspend fun deleteTask(task: MarsRealState)

    @Query("DELETE FROM mars_table")
    suspend fun deleteAll()
    //Traer todos los elementos de la tabla. LEER a todos los get se le agrega}
    //LiveData para mostrarselos al patrón observador
    @Query("SELECT * FROM mars_table ORDER BY id DESC")
    fun getAllTask() : LiveData<List<MarsRealState>>

    //Encuetra una tarea por el titulo y limita a una respuesta
    @Query("SELECT * FROM mars_table WHERE type = :type LIMIT 1")
    fun getTaskByType(type: String) : LiveData<MarsRealState>
    //Encuetra una tarea por id
    @Query("SELECT * FROM mars_table WHERE id = :id")
    fun getTaskById(id: String) : LiveData<MarsRealState>

}