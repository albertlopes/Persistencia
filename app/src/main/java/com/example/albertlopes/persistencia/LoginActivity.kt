package com.example.albertlopes.persistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("myApp", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("MANTER_CONECTADO",false))
        {
            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        }

        btLogin.setOnClickListener {
            val editor = sharedPreferences.edit()

            editor.putBoolean("MANTER_CONECTADO",cbManterConectado.isChecked)
            editor.putString("USUARIO",etLogin.text.toString())
            editor.apply()
            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        }
    }
}
