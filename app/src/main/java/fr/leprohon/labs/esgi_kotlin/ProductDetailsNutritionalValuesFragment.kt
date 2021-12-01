package fr.leprohon.labs.esgi_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import fr.leprohon.labs.esgi_kotlin.databases.Product

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailsNutritionalValuesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailsNutritionalValuesFragment : Fragment() {

    private val model: SharedProductView by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_details_nutritional_values, container, false);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val value = model.selected.value
        with(view) {
            findViewById<TextView>(R.id.energy100).text = value?.nutritionFactsItem?.energy?.quantityfor100g.toString()
            findViewById<TextView>(R.id.fat100g).text = value?.nutritionFactsItem?.matiere_g?.quantityfor100g.toString()
            findViewById<TextView>(R.id.acid100g).text = value?.nutritionFactsItem?.acide_gras_saturee?.quantityfor100g.toString()
            findViewById<TextView>(R.id.glucid100g).text = value?.nutritionFactsItem?.glucid?.quantityfor100g.toString()
            findViewById<TextView>(R.id.sugar100g).text = value?.nutritionFactsItem?.sugar?.quantityfor100g.toString()
            findViewById<TextView>(R.id.fiber100g).text = value?.nutritionFactsItem?.fiber?.quantityfor100g.toString()
            findViewById<TextView>(R.id.protein100g).text = value?.nutritionFactsItem?.protein?.quantityfor100g.toString()
            findViewById<TextView>(R.id.salt100g).text = value?.nutritionFactsItem?.sel?.quantityfor100g.toString()
            findViewById<TextView>(R.id.sodium100g).text = value?.nutritionFactsItem?.sodium?.quantityfor100g.toString()

            findViewById<TextView>(R.id.energypart).text = value?.nutritionFactsItem?.energy?.quantityperportion.toString()
            findViewById<TextView>(R.id.fatpart).text = value?.nutritionFactsItem?.matiere_g?.quantityperportion.toString()
            findViewById<TextView>(R.id.acidparpart).text = value?.nutritionFactsItem?.acide_gras_saturee?.quantityperportion.toString()
            findViewById<TextView>(R.id.glucidparpart).text = value?.nutritionFactsItem?.glucid?.quantityperportion.toString()
            findViewById<TextView>(R.id.sugarparpart).text = value?.nutritionFactsItem?.sugar?.quantityperportion.toString()
            findViewById<TextView>(R.id.fiberparpart).text = value?.nutritionFactsItem?.fiber?.quantityperportion.toString()
            findViewById<TextView>(R.id.proteinparpart).text = value?.nutritionFactsItem?.protein?.quantityperportion.toString()
            findViewById<TextView>(R.id.saltparpart).text = value?.nutritionFactsItem?.sel?.quantityperportion.toString()
            findViewById<TextView>(R.id.sodiumparpart).text = value?.nutritionFactsItem?.sodium?.quantityperportion.toString()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductDetailsNuatritionalValuesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductDetailsNutritionalValuesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}