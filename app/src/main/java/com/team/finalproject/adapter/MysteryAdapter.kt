package com.team.finalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.finalproject.R
import com.team.finalproject.model.MysteryModel
import kotlinx.android.synthetic.main.item_genre.view.*

class MysteryAdapter(private val listener: (MysteryModel) -> Unit) : RecyclerView.Adapter<MysteryAdapter.ViewHolder>() {
    private val listAllMystery = ArrayList<MysteryModel>()

    fun setData(items: ArrayList<MysteryModel>) {
        listAllMystery.clear()
        listAllMystery.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: MysteryModel, listGenre: (MysteryModel) -> Unit) {
            with(itemView) {
                tv_novel_title_genre.setText(model.titleMystery)
                tv_novel_genre_genre.setText(model.genreMystery)
                tv_synopsis_genre.setText(model.synopsisMystery)

                itemView.setOnClickListener { listGenre(model) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAllMystery[position], listener)
    }

    override fun getItemCount(): Int = listAllMystery.size
}