package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cookiemaker.R

class NewRecipeFragment : Fragment () {

    interface OnIngredientsClicked{
        fun OnIngredientsClick()
    }

    private var listener : OnIngredientsClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnIngredientsClicked
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newrecipe,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val butSave : Button = view.findViewById(R.id.butSave)
        val butIngredients : Button = view.findViewById(R.id.butIngredients)

        butSave.setOnClickListener{ _ : View ->
            //
        }

        butIngredients.setOnClickListener{ _ : View ->
            listener?.OnIngredientsClick()
        }
    }
}