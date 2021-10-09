package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.adapters.IngredientsListAdapter
import com.example.cookiemaker.adapters.RecipesListAdapter
import com.example.cookiemaker.fragments.IngredientsFragment
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class IngredientsActivity : AppCompatActivity() , IngredientsFragment.OnIngredientClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("llego", "Entra a Ingredient Activity")
        setContentView(R.layout.activity_ingredients)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContentNewRecipe, IngredientsFragment())
        ft.commit()

    }

    override fun onIngredientClick(ingredient : String) {
        val intent : Intent = Intent()
        val bundle : Bundle = Bundle()
        bundle.putString("nombre", ingredient)
        intent.putExtra("data",bundle)
        setResult(RESULT_OK,intent)
        finish()
    }
}