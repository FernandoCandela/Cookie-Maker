package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cookiemaker.R

class AddRecipeFragment : Fragment() {

    interface OnAddRecipeClicked {
        fun onAddRecipeClick()
    }

    private var listener: OnAddRecipeClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnAddRecipeClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_addrecipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val butAddRecipe: Button = view.findViewById(R.id.butAddRecipe)

        butAddRecipe.setOnClickListener { _: View ->
            listener?.onAddRecipeClick()
        }
    }
}