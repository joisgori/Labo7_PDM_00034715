package com.feranstirman.labo7.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.feranstirman.labo7.Database.GithubDAO
import com.feranstirman.labo7.Database.GithubRepo

class GithubRepository (private val repoDao: GithubDAO) {

    @WorkerThread
    suspend fun insert(repo: GithubRepo){ //Hay ue suspender una función que mande a llamar otra ya suspendida
        repoDao.insert(repo)
    }
    //Seguimos con la funciones que nos hacen falta que ya tenemos en el Dao

    //Acá decido qué hará cada una de mis funciones.
    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}