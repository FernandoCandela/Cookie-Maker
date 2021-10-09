package com.example.cookiemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.cookiemaker.fragments.AddRecipeFragment
import com.example.cookiemaker.fragments.RecipesFragment

class MainActivity : AppCompatActivity(), AddRecipeFragment.OnAddRecipeClicked {

    private val fragments = mutableListOf<Fragment>()

    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        username = intent.getBundleExtra("data")?.getString("name").toString()
        Log.i("username", username)
        setContentView(R.layout.activity_main)

        fragments.add(RecipesFragment())

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, fragments[0])
        ft.commit()

    }
    
    override fun onAddRecipeClick() {
        val intent: Intent = Intent()
        intent.setClass(this, NewRecipeActivity::class.java)
        val bundle: Bundle = Bundle()
        bundle.putString("username",username)
        intent.putExtra("data2",bundle)
        Log.i("antes de","morir")
        startActivity(intent)
    }
}