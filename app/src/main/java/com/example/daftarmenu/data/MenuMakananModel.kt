package com.example.daftarmenu.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuMakananModel(
    @PrimaryKey(autoGenerate = true)
    var idMenu:Int?=null,
    var namaMenu:String?=null,
    var hargaMenu:String?=null,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var gambarMenu:ByteArray?
)
