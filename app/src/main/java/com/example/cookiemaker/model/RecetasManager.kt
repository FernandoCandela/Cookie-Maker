package pe.edu.ulima.pm.ulgamestore.model

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
        private var instance : RecetasManager? = null
    }

    fun getInstance() : RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas() : List<Receta> {
        mRecetas.add(Receta(1,"Galleta Chocolate","ren",mIngredientes))
        mRecetas.add(Receta(2,"Galleta Vainilla","ren",mIngredientes))
        mRecetas.add(Receta(3,"Happy Brownie","ren",mIngredientes))
        mRecetas.add(Receta(4,"Cheesecake","ren",mIngredientes))

        return mRecetas
    }

    fun addReceta(receta : Receta) {
        mRecetas.add(receta)
    }

    fun getReceta(id : Int) : Receta? {
        // Debe implementarlo !!!
        return null
    }

    fun getIngredientes() : List<Ingrediente> {
        return mIngredientes
    }

}