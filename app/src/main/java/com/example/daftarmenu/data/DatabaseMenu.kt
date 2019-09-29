package com.example.daftarmenu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database
    (entities = arrayOf(
    MenuMakananModel::class,
    MenuMinumanModel::class),version = 1)
abstract class DatabaseMenu:RoomDatabase() {

    abstract fun menuDataAksesObjek() :MenuDataAksesObjek
    companion object{
        var INSTANCE:DatabaseMenu?=null
        fun getInstance(context: Context):DatabaseMenu?{
            if (INSTANCE==null){
                synchronized(DatabaseMenu::class.java){
                    INSTANCE= Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseMenu::class.java,"DatabaseMenu.db"
                    ).build()
                }
        }
            return INSTANCE
    }
        fun destroyInstance(){
            INSTANCE=null
        }
    }
}