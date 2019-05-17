package com.feranstirman.labo7.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//Acá en dao colocaremos todas nuestras queries
@Dao
interface GithubDAO {

    //Colocas tu entidad
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo) //hicimos async esta función

    @Query("SELECT s_name FROM repos")
    fun getAllRepos():LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()
}