package com.example.daftarmenu.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDataAksesObjek {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahMakanan(makananModel: MenuMakananModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahMinuman(minumanModel: MenuMinumanModel)

    @Query("select * from menumakananmodel")
    fun ambilMenuMakanan():LiveData<List<MenuMakananModel>>

    @Query("select * from menuminumanmodel")
    fun ambilMenuMinuman():LiveData<List<MenuMinumanModel>>

}