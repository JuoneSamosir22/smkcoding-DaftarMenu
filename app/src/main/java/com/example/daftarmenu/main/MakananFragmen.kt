package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.synthetic.main.makanan_fragmen.rv_makanan

class MakananFragmen: Fragment() {
    companion object{
        fun getInstance(): MakananFragmen {
            return MakananFragmen()
        }
    }
    val dataMakanan= mutableListOf<MenuModel>()
    val rvAdapter=RvAdapter(dataMakanan)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.makanan_fragmen,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=rvAdapter
                rv_makanan.layoutManager=LinearLayoutManager(context)

        addDummyData()
    }
    private fun addDummyData(){
        dataMakanan.add(
            MenuModel("Nasi Goreng",
            "Rp 25.000,00",R.drawable.nasi_goreng))
        dataMakanan.add(
            MenuModel("Nasi Bancaan",
            "Rp 20.000,00", R.drawable.nasi_bancaan))
        dataMakanan.add(
            MenuModel("Nasi Kuning",
            "Rp 23.000,00", R.drawable.nasi_kuning))

    }
}