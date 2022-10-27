package com.example.nakama

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val fullname = findViewById<EditText>(R.id.fullname)
        val birthdate = findViewById<EditText>(R.id.birthdate)
        val tempat = findViewById<EditText>(R.id.tempat)



        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        birthdate.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, monthOfYear, dayOfMonth ->

                val simpleDateFormat = SimpleDateFormat("EEEE")
                val date = Date(mYear, monthOfYear, dayOfMonth - 1)
                val dayString = simpleDateFormat.format(date) //returns true day name for current month only

                birthdate.setText("$dayOfMonth/${monthOfYear + 1}/$mYear")

            }, year, month, day)

            dpd.show()
        }


        btnRegisterListener()

        }
    private fun btnRegisterListener(){
        btn_register.setOnClickListener{
            val nama = fullname.text.toString()
            val tglLahir = birthdate.text.toString()
            val tempat = tempat.text.toString()
            val intent = Intent(this, TableActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("tglLahir", tglLahir)
            intent.putExtra("tempat", tempat)
            startActivity(intent);
        }
    }
    }