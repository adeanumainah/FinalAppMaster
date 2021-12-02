package com.team.finalproject.genre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.finalproject.DetailNovelActivity
import com.team.finalproject.R
import com.team.finalproject.adapter.MysteryAdapter
import com.team.finalproject.adapter.NovelListAdapter
import com.team.finalproject.model.GenreModel
import com.team.finalproject.model.MysteryModel
import kotlinx.android.synthetic.main.fragment_all_genre.*
import kotlinx.android.synthetic.main.fragment_mystery.*

class MysteryFragment : Fragment() {
    private val listMystery = ArrayList<MysteryModel>()
    private lateinit var mysteryAdapter: MysteryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mystery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_mystery.setHasFixedSize(true)
        listMystery.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        mysteryAdapter = MysteryAdapter { showDetails(it) }
        mysteryAdapter.notifyDataSetChanged()
        mysteryAdapter.setData(getListGenre())
        rv_mystery.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_mystery.adapter = mysteryAdapter
        rv_mystery.setHasFixedSize(true)
    }

    private fun showDetails(it: MysteryModel) {
        val intent = Intent(context, DetailNovelActivity::class.java)
        intent.putExtra(DetailNovelActivity.KEY_ALL_GENRE, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<MysteryModel> {
        val titleMystery = resources.getStringArray(R.array.title_mystery)
        val genreMystery = resources.getStringArray(R.array.genre_mystery)
        val synopsisMystery = resources.getStringArray(R.array.genre_mystery)
        val authorMystery = resources.getStringArray(R.array.author_mystery)

        val listGenre = ArrayList<MysteryModel>()

        for (position in titleMystery.indices){
            val novel = MysteryModel(
                titleMystery[position],
                genreMystery[position],
                synopsisMystery[position],
                authorMystery[position],
            )
            listGenre.add(novel)
        }
        return listGenre
    }

}