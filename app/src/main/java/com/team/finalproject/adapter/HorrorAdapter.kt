package com.team.finalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.finalproject.R
import com.team.finalproject.model.HorrorModel
import kotlinx.android.synthetic.main.item_genre.view.*

class HorrorAdapter(private val listener: (HorrorModel) -> Unit) : RecyclerView.Adapter<HorrorAdapter.ViewHolder>() {
    private val listAllHorror = ArrayList<HorrorModel>()

    fun setData(items: ArrayList<HorrorModel>) {
        listAllHorror.clear()
        listAllHorror.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: HorrorModel, listGenre: (HorrorModel) -> Unit) {
            with(itemView) {
                tv_novel_title_genre.setText(model.titleHorror)
                tv_novel_genre_genre.setText(model.genreHorror)
                tv_synopsis_genre.setText(model.synopsisHorror)

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
        holder.bind(listAllHorror[position], listener)
    }

    override fun getItemCount(): Int = listAllHorror.size
}