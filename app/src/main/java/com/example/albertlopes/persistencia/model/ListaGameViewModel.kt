package com.example.albertlopes.persistencia.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.albertlopes.persistencia.dao.BancoDeDados

class ListaGameViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var games: LiveData<List<Game>>
    private val bd: BancoDeDados =
            BancoDeDados.getDatabase(application.applicationContext)!!

    init {
        carregarDados()
    }

    private fun carregarDados() {
     games = bd.gameDAO().lerGames()
    }
}
