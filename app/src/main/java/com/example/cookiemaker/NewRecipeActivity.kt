package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cookiemaker.fragments.NewRecipeFragment
import com.example.cookiemaker.fragments.NewRecipeIngredientsFragment
import com.example.cookiemaker.fragments.RecipesFragment
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente
import pe.edu.ulima.pm.ulgamestore.model.Receta
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class NewRecipeActivity : AppCompatActivity(), NewRecipeFragment.OnIngredientsClicked {

    private var ingredients = arrayListOf<Ingrediente>()
    private lateinit var usuario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe)

        usuario = intent.getBundleExtra("data")?.getString("username").toString()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContentNewRecipe, NewRecipeIngredientsFragment(ingredients))
        ft.commit()
    }

    override fun OnIngredientsClick() {
        val intent: Intent = Intent(this, IngredientsActivity::class.java)
        startActivityForResult(intent, 10)
    }

    override fun OnSaveClick(newRecipeName: String, id:Int) {
        val receta = Receta(id, newRecipeName, usuario, ingredients)
        RecetasManager().getInstance().addReceta(receta)

        val intent: Intent = Intent()
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                val ingrediente = data?.getBundleExtra("data")?.getString("nombre")
                if (ingrediente != null) {
                    Log.i("ingrediente activity", ingrediente)
                }
                ingredients.add(Ingrediente(ingrediente.toString()))

                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.flaContentNewRecipe, NewRecipeIngredientsFragment(ingredients))
                ft.commit()


            }
        }

    }


}
