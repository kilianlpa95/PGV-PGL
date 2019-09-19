package com.example.firstprojectclient

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_extra_actvity.*

class ExtraActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_actvity)

        button2.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val constFondo = findViewById<ConstraintLayout>(R.id.constFondo)

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                constFondo.setBackgroundColor(Color.BLUE)
            } else {
                constFondo.setBackgroundColor(Color.RED)
            }
        }
    }


}
