package com.example.daftarmenu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.adapter.RvAdapterMakanan.MenuViewHolder
import com.example.daftarmenu.data.MenuMakananModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.ivgambar
import kotlinx.android.synthetic.main.item_list.tvharga
import kotlinx.android.synthetic.main.item_list.tvnama

class RvAdapterMakanan(private val data: List<MenuMakananModel>)
    : RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(layout.item_list, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindData(item: MenuMakananModel) {
            tvnama.text = item.namaMenu
            tvharga.text = item.hargaMenu
            Glide.with(containerView).load(item.gambarMenu).into(ivgambar)

            itemView.setOnClickListener{
                Toast.makeText(containerView.context, item.namaMenu, Toast.LENGTH_SHORT).show()
            }

        }
    }
}