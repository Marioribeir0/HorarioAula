package com.example.horarioaula

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nomeUser = findViewById<EditText>(R.id.NomeAluno)
        val btnAluno = findViewById<Button>(R.id.Button_Aluno)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        btnAluno.setOnClickListener {

            getSharedPreferences("dados", MODE_PRIVATE)
                .edit().putString("nome", nomeUser.text.toString()).apply()

            val intent = Intent(this, Cursos::class.java)
            startActivity(intent)
        }

    }
}