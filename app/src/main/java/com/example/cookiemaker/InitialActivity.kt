package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InitialActivity : AppCompatActivity() {
    private lateinit var eteName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        eteName = findViewById(R.id.eteName)

        val butLogin: Button = findViewById(R.id.butLogin)

        butLogin.setOnClickListener { _: View ->
            val intent: Intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putString("name" , eteName.text.toString())
            intent.putExtra("data",bundle)

            startActivity(intent)
        }
    }

}