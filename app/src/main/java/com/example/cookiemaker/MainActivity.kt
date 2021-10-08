package com.example.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cookiemaker.fragments.AddRecipeFragment
import com.example.cookiemaker.fragments.RecipesFragment

class MainActivity : AppCompatActivity(), AddRecipeFragment.OnAddRecipeClicked {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RecipesFragment())

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent,fragments[0])
        ft.commit()

    }

    fun changeAddRecipeFragment(){
       // val fragment = fragments[0]
       // val ft= supportFragmentManager.beginTransaction()
       // ft.replace(R.id.flaContent,fragment)
//
       // ft.commit()
    }

    override fun onAddRecipeClick() {
        changeAddRecipeFragment()
    }
}