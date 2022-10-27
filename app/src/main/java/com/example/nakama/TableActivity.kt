package com.example.nakama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val name = findViewById<TextView>(R.id.namaLengkap)
        val birthdate = findViewById<TextView>(R.id.tglLahir)
        val intent = intent

        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")

        name.text = nama
        birthdate.text = tglLahir

        backListener()
    }
    private fun backListener(){
        back.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}