package com.example.cookiemaker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

class ViewRecipeAdapter(
    private val IngredientsList: List<Ingrediente>
) : RecyclerView.Adapter<ViewRecipeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tviNewRecipeIngredient: TextView


        init {
            tviNewRecipeIngredient = view.findViewById(R.id.tviNewRecipeIngredient)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_new_recipe_ingredient, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviNewRecipeIngredient.text = IngredientsList[position].nombre

    }

    override fun getItemCount(): Int {
        return IngredientsList.size
    }
}

