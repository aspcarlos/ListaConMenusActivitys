package com.example.lista

import android.os.Bundle
import com.example.lista.databinding.ActivityEditarPeliculasBinding


class EditarPeliculasActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditarPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}