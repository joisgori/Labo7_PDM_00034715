package com.feranstirman.labo7.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {
    abstract fun repoDao(): GithubDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        //Queremos hacer una instancia única de nuestra base de datos...
        fun getInstance(context: Context): RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                //Creo una variable nulleable estática, y creo una función que en base al contexto
                //Verificará si la base de datos existe o no...
                //synchronized es un método para sincronizar hilos,
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "RepoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}