package com.example.lista

import android.os.Bundle
import com.example.lista.databinding.ActivityInfoBinding

class InfoActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}