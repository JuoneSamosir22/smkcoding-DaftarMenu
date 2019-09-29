package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.adapter.RvAdapterMakanan
import com.example.daftarmenu.data.DatabaseMenu
import com.example.daftarmenu.data.DatabaseMenu.Companion
import com.example.daftarmenu.data.MenuMakananModel
import kotlinx.android.synthetic.main.makanan_fragmen.rv_makanan

class MakananFragmen: Fragment() {
    companion object{
        fun getInstance(): MakananFragmen {
            return MakananFragmen()
        }
    }
    val dataMakanan= mutableListOf<MenuMakananModel>()
    var mRvAdapterMakanan= RvAdapterMakanan(dataMakanan)
    var db:DatabaseMenu?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.makanan_fragmen,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=mRvAdapterMakanan
                rv_makanan.layoutManager=LinearLayoutManager(context)
        db= DatabaseMenu.getInstance(context!!)
        getMenuMakanan()

    }
    private fun getMenuMakanan(){
        db?.menuDataAksesObjek()?.ambilMenuMakanan()
            ?.observe(this, Observer { hasil->
                when(hasil.size==0){
                    true->{
                        Toast.makeText(
                            context,"Data Makanan Masih Kosong",
                            Toast.LENGTH_SHORT).show()
                    }
                    false->{dataMakanan.clear()
                            dataMakanan.addAll(hasil)
                            mRvAdapterMakanan
                                .notifyDataSetChanged()
                    }
                }
            })
    }
}