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
import com.team.finalproject.adapter.HorrorAdapter
import com.team.finalproject.adapter.NovelListAdapter
import com.team.finalproject.model.GenreModel
import com.team.finalproject.model.HorrorModel
import kotlinx.android.synthetic.main.fragment_all_genre.*
import kotlinx.android.synthetic.main.fragment_horror.*

class HorrorFragment : Fragment() {
    private val listHorror = ArrayList<HorrorModel>()
    private lateinit var horrorAdapter: HorrorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horror, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_horror.setHasFixedSize(true)
        listHorror.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        horrorAdapter = HorrorAdapter { showDetails(it) }
        horrorAdapter.notifyDataSetChanged()
        horrorAdapter.setData(getListGenre())
        rv_horror.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_horror.adapter = horrorAdapter
        rv_horror.setHasFixedSize(true)
    }

    private fun showDetails(it: HorrorModel) {
        val intent = Intent(context, DetailNovelActivity::class.java)
        intent.putExtra(DetailNovelActivity.KEY_ALL_GENRE, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<HorrorModel> {
        val titleHorror = resources.getStringArray(R.array.title_horror)
        val genreHorror = resources.getStringArray(R.array.genre_horror)
        val synopsisHorror = resources.getStringArray(R.array.synopsis_horror)
        val authorHorror = resources.getStringArray(R.array.author_horror)

        val listGenre = ArrayList<HorrorModel>()

        for (position in titleHorror.indices){
            val novel = HorrorModel(
                titleHorror[position],
                genreHorror[position],
                synopsisHorror[position],
                authorHorror[position],
            )
            listGenre.add(novel)
        }
        return listGenre
    }

}