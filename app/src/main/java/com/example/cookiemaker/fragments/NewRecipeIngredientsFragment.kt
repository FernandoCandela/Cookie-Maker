package com.example.cookiemaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import com.example.cookiemaker.adapters.NewRecipesIngredientsListAdapter
import com.example.cookiemaker.adapters.RecipesListAdapter
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class NewRecipeIngredientsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_ingredients,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}