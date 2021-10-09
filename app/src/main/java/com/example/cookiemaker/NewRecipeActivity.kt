package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cookiemaker.fragments.NewRecipeFragment
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import com.example.cookiemaker.fragments.RecipesFragment

class NewRecipeActivity : AppCompatActivity(), NewRecipeFragment.OnIngredientsClicked{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("newREcipeActivity", "se crea")
        setContentView(R.layout.activity_new_recipe)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContentNewRecipe,NewRecipeIngredientsFragment())
        ft.commit()
    }

    override fun OnIngredientsClick() {
        Log.i("antes","Llega a la funcion")
        val intent: Intent = Intent(this,IngredientsActivity::class.java)
        Log.i("justo antes","crea el intent")
        startActivityForResult(intent,10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 10){
            if(resultCode == RESULT_OK){

                Log.i("llego","resultadoOk")
            }
        }

    }


}