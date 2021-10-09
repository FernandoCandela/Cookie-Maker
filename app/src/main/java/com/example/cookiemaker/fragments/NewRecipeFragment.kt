package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.cookiemaker.R
import com.example.cookiemaker.adapters.RecipesListAdapter
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class NewRecipeFragment : Fragment() {

    interface OnIngredientsClicked {
        fun OnIngredientsClick()
        fun OnSaveClick(newRecipeName: String,id:Int)
    }

    private var listener: OnIngredientsClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnIngredientsClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newrecipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eteNewRecipeName: EditText = view.findViewById(R.id.eteNewRecipeName)
        val butSave: Button = view.findViewById(R.id.butSave)
        val butIngredients: Button = view.findViewById(R.id.butIngredients)

        butSave.setOnClickListener { _: View ->
            //boton de guardar
            //val id = RecipesListAdapter().getItemCount() +1
            var id = RecetasManager().getInstance().getRecetas().size
            if(id!=0){
                id=id-1
            }

            listener?.OnSaveClick(eteNewRecipeName.text.toString(),id)

        }

        butIngredients.setOnClickListener { _: View ->
            listener?.OnIngredientsClick()
        }
    }
}