package com.example.nakama

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        val name = findViewById<TextView>(R.id.namaLengkap)
        val birthdate = findViewById<TextView>(R.id.tglLahir)
        val place = findViewById<TextView>(R.id.tempatLahir)
        val intent = intent

        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tempat = intent.getStringExtra("tempat")


        name.text = nama
        birthdate.text = tglLahir
        place.text = tempat

        backListener()
    }
    private fun backListener(){
        back.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}