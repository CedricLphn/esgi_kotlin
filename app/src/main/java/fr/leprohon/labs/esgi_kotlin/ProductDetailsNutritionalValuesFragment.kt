package fr.leprohon.labs.esgi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

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
        val view = inflater.inflate(R.layout.fragment_product_details_nutritional_values, container, false)
        return view
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
}