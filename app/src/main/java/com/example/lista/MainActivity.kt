package com.example.lista

import adapter.FilmAdapter
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista.databinding.ActivityMainBinding

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTitle("Listas")

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buscar.setOnClickListener{
            binding.buscar.isInvisible = false
        }
        val decoration = DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL)

        binding.recycler.layoutManager = LinearLayoutManager(this)

        var adapter=FilmAdapter(FilmProvider.filmList)
        binding.recycler.adapter = adapter

        binding.buscar.addTextChangedListener {buscar ->
            val filtroPelicula = FilmProvider.filmList.filter { film ->
                film.title.contains(buscar.toString())  }
        }

        binding.buscar.addTextChangedListener { filtro ->
            val filtroPelicula = FilmProvider.filmList.filter { film ->
                film.title.lowercase().contains(filtro.toString().lowercase()) }
                adapter.actualizarPeliculas(filtroPelicula)
        }
    }

}