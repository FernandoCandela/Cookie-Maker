package com.example.cookiemaker

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import com.example.cookiemaker.fragments.ViewRecipeFragment
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class ViewRecipeActivity : AppCompatActivity() {

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recipe)
        id = intent.getBundleExtra("data")?.getInt("id")!!

        val rviRecipeTit = findViewById<TextView>(R.id.tviRecipeTitle)

        rviRecipeTit.text =RecetasManager().getInstance().getReceta(id)?.nombre

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fraIngredientList, ViewRecipeFragment(id))
        ft.commit()

    }
}