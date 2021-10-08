package com.example.cookiemaker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cookiemaker.fragments.NewRecipeFragment

class NewRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("newREcipeActivity", "se crea")
        setContentView(R.layout.activity_new_recipe)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContentNewRecipe,NewRecipeFragment())
        ft.commit()
    }
}