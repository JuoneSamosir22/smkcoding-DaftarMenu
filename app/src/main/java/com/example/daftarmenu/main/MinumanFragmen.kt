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
import kotlinx.android.synthetic.main.minuman_fragmen.rv_minuman

class MinumanFragmen : Fragment() {
    companion object {
        fun getInstance(): MinumanFragmen {
            return MinumanFragmen()
        }
    }

    val dataMinuman = mutableListOf<MenuModel>()
    val rvAdapter = RvAdapter(dataMinuman)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.minuman_fragmen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_minuman.adapter = rvAdapter
        rv_minuman.layoutManager = LinearLayoutManager(context)

        addHelloData()
    }

    private fun addHelloData() {
        dataMinuman.add(
            MenuModel(
                "Wedang Jahe",
                "Rp 8.000,00", R.drawable.wedang_jahe
            )
        )
        dataMinuman.add(
            MenuModel(
                "Es Dawet Spesial",
                "Rp 9.000,00", R.drawable.dawet_special
            )
        )
        dataMinuman.add(
            MenuModel(
                "Es Melon Serut",
                "Rp 10.000,00", R.drawable.es_melon_serut
            )
        )
    }
}