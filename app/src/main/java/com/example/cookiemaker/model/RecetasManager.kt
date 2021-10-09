package pe.edu.ulima.pm.ulgamestore.model

import android.util.Log

class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()

    init {
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
    }

    companion object {
        private var instance: RecetasManager? = null
    }

    fun getInstance(): RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas(): List<Receta> {
        //mRecetas.add(Receta(1,"Galleta Chocolate","Fernando",mIngredientes))
        //mRecetas.add(Receta(2,"Galleta Vainilla","Renato",mIngredientes))
        //mRecetas.add(Receta(3,"Happy Brownie","Piero",mIngredientes))
        //mRecetas.add(Receta(4,"Cheesecake","Rodrigo",mIngredientes))
        Log.i("recetas", mRecetas.toString())
        return mRecetas
    }

    fun addReceta(receta: Receta) {
        mRecetas.add(receta)
        Log.i("recetasadd", mRecetas.toString())
    }

    fun getReceta(id: Int): Receta? {
        return mRecetas[id]

    }

    fun getIngredientes(): List<Ingrediente> {
        return mIngredientes
    }

}