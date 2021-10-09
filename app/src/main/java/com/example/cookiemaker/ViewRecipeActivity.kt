package com.example.cookiemaker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import com.example.cookiemaker.fragments.ViewRecipeFragment

class ViewRecipeActivity : AppCompatActivity() {

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recipe)
        id = intent.getBundleExtra("data")?.getInt("id")!!



        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fraIngredientList, ViewRecipeFragment(id))
        ft.commit()

    }
}