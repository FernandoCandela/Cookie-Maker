package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import com.example.cookiemaker.adapters.RecipesListAdapter
import pe.edu.ulima.pm.ulgamestore.model.Receta
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class RecipesFragment : Fragment() {

    interface OnRecipeClicked {
        fun onRecipeClick(recipeId: Int)
    }

    private var listener: OnRecipeClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnRecipeClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviRecipes = view.findViewById<RecyclerView>(R.id.rviRecipes)
        rviRecipes.adapter = RecipesListAdapter(
            RecetasManager().getInstance().getRecetas(),
            { recipeId: Int ->
                Log.i("recipeId",recipeId.toString())
                listener?.onRecipeClick(recipeId)

            }
        )
    }
}

