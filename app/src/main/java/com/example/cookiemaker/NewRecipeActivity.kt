package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cookiemaker.fragments.NewRecipeFragment
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import com.example.cookiemaker.fragments.RecipesFragment
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

class NewRecipeActivity : AppCompatActivity(), NewRecipeFragment.OnIngredientsClicked{

    private var ingredients = arrayListOf<Ingrediente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContentNewRecipe,NewRecipeIngredientsFragment(ingredients))
        ft.commit()
    }

    override fun OnIngredientsClick() {
        val intent: Intent = Intent(this,IngredientsActivity::class.java)
        startActivityForResult(intent,10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 10){
            if(resultCode == RESULT_OK){
                val ingrediente = data?.getBundleExtra("data")?.getString("nombre")
                if (ingrediente != null) {
                    Log.i("ingrediente activity", ingrediente)
                }
                ingredients.add(Ingrediente(ingrediente.toString()))

                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.flaContentNewRecipe,NewRecipeIngredientsFragment(ingredients))
                ft.commit()



            }
        }

    }


}
