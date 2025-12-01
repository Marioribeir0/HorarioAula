package com.example.horarioaula

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class Cursos : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_cursos)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val nomeAluno = findViewById<TextView>(R.id.Aluno)

            val sharedPref = getSharedPreferences("dados", MODE_PRIVATE)
            val nome = sharedPref.getString("nome", "Aluno")

            nomeAluno.text = "Olá, $nome!"

            // Clicar nas Imagens
            val mobile = findViewById<ImageView>(R.id.Mobile)
            val engenharia = findViewById<ImageView>(R.id.EngenhariaSoftware)
            val cyber = findViewById<ImageView>(R.id.Cyber)
            val ciencia = findViewById<ImageView>(R.id.CienciaComputação)

            //  Desenvolvimento Mobile
            mobile.setOnClickListener {
                val intent = Intent(this, HorarioMobile::class.java)
                startActivity(intent)
            }

            //  Engenharia de Software
            engenharia.setOnClickListener {
                val intent = Intent(this, HorarioEngenharia::class.java)
                startActivity(intent)
            }

            //  Cybersecurity
            cyber.setOnClickListener {
                val intent = Intent(this, HorarioCyber::class.java)
                startActivity(intent)
            }

            //  Ciência da Computação
            ciencia.setOnClickListener {
                val intent = Intent(this, HorarioCiencia::class.java)
                startActivity(intent)
            }
        }
    }
