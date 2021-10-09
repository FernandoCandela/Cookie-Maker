package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import com.example.cookiemaker.adapters.IngredientsListAdapter
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class IngredientsFragment : Fragment() {

    interface OnIngredientClicked {
        fun onIngredientClick(ingredient: String)
    }

    private var listener: OnIngredientClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnIngredientClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_ingredients, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviRecipeIngredients = view.findViewById<RecyclerView>(R.id.rviRecipeIngredients)
        rviRecipeIngredients.adapter = IngredientsListAdapter(
            RecetasManager().getIngredientes()
        ) { recipeId: Int ->
            val ingredient = RecetasManager().getIngredientes()[recipeId].nombre
            listener?.onIngredientClick(ingredient)
        }

    }
}