package com.example.cookiemaker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

class IngredientsListAdapter(
    private val ingredientstList: List<Ingrediente>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<IngredientsListAdapter.ViewHolder>() {

    class ViewHolder( view: View, val listener : (Int)->Unit) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val tviNewRecipeIngredient: TextView

        init {
            tviNewRecipeIngredient = view.findViewById(R.id.tviNewRecipeIngredient)
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            listener(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_recipe_ingredient, parent, false)
        val viewHolder = ViewHolder(view,listener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviNewRecipeIngredient.text = ingredientstList[position].nombre
    }

    override fun getItemCount(): Int {
        return ingredientstList.size
    }

}