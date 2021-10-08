package com.example.cookiemaker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import pe.edu.ulima.pm.ulgamestore.model.Receta

class RecipesListAdapter(private val recipesList: List<Receta>) :
    RecyclerView.Adapter<RecipesListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iviRecipeImage : ImageView
        val tviUserName : TextView
        val tviRecipeName :TextView

        init{
            iviRecipeImage =view.findViewById(R.id.iviRecipeImage)
            tviUserName =view.findViewById(R.id.tviUserName)
            tviRecipeName =view.findViewById(R.id.tviRecipeName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_recipe,parent,false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviUserName.text = recipesList[position].usuario
        holder.tviRecipeName.text = recipesList[position].nombre
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }
}