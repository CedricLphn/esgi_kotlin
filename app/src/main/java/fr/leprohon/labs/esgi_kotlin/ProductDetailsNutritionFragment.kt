package fr.leprohon.labs.esgi_kotlin

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.text.bold
import androidx.fragment.app.activityViewModels

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailsNutritionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailsNutritionFragment : Fragment() {
    private val model: SharedProductView by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun setTextStyle(label: String, content: String): SpannableStringBuilder {
        return SpannableStringBuilder()
            .bold { append(content).append(" $label") }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val product = model.selected.value!!

        val view = inflater.inflate(R.layout.fragment_product_details_nutrition, container, false);

        with(view) {

            var colorFat : Int = 0
            var labelqtyFat : Int = 0

            var colorAcid : Int = 0
            var labelqtyacid : Int = 0

            var colorSugar : Int = 0
            var labelqtySugar : Int = 0

            var colorSalt : Int = 0
            var labelqtySalt : Int = 0

            when {
                product.nutritionFactsItem.matiere_g.quantityfor100g < 3 -> {
                    colorFat = R.color.nutrient_level_low
                    labelqtyFat = R.string.level_low
                }
                product.nutritionFactsItem.matiere_g.quantityfor100g in 3.0..20.0 -> {
                    colorFat = R.color.nutrient_level_moderate
                    labelqtyFat = R.string.level_moderate
                }
                else -> {
                    colorFat = R.color.nutrient_level_high
                    labelqtyFat = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.acide_gras_saturee.quantityfor100g < 1.5 -> {
                    colorAcid = R.color.nutrient_level_low
                    labelqtyacid = R.string.level_low
                }
                product.nutritionFactsItem.acide_gras_saturee.quantityfor100g in 1.5..5.0 -> {
                    colorAcid = R.color.nutrient_level_moderate
                    labelqtyacid = R.string.level_moderate
                }
                else -> {
                    colorAcid = R.color.nutrient_level_high
                    labelqtyacid = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.sugar.quantityfor100g < 5.0 -> {
                    colorSugar = R.color.nutrient_level_low
                    labelqtySugar = R.string.level_low
                }
                product.nutritionFactsItem.sugar.quantityfor100g in 5.0..12.5 -> {
                    colorSugar = R.color.nutrient_level_moderate
                    labelqtySugar = R.string.level_moderate
                }
                else -> {
                    colorSugar = R.color.nutrient_level_high
                    labelqtySugar = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.sel.quantityfor100g < 0.5 -> {
                    colorSalt = R.color.nutrient_level_low
                    labelqtySalt = R.string.level_low
                }
                product.nutritionFactsItem.sel.quantityfor100g in 0.5..1.5 -> {
                    colorSalt = R.color.nutrient_level_moderate
                    labelqtySalt = R.string.level_moderate
                }
                else -> {
                    colorSalt = R.color.nutrient_level_high
                    labelqtySalt = R.string.level_high
                }
            }


            findViewById<TextView>(R.id.info_fat).text = setTextStyle(
                getString(R.string.fat),
                product.nutritionFactsItem.matiere_g.quantityfor100g.toString()
            )
            findViewById<TextView>(R.id.info_satured_acid).text = setTextStyle(
                getString(R.string.acid),
                product.nutritionFactsItem.acide_gras_saturee.quantityfor100g.toString()
            )
            findViewById<TextView>(R.id.info_sugar).text = setTextStyle(
                getString(R.string.sugar),
                product.nutritionFactsItem.sugar.quantityfor100g.toString()
            )
            findViewById<TextView>(R.id.info_salt).text = setTextStyle(
                getString(R.string.salt),
                product.nutritionFactsItem.sel.quantityfor100g.toString()
            )



            findViewById<TextView>(R.id.quantity_fat).text = getString(labelqtyFat)
            findViewById<TextView>(R.id.quantity_satured_acid).text = getString(labelqtyacid)
            findViewById<TextView>(R.id.quantity_sugar).text = getString(labelqtySugar)
            findViewById<TextView>(R.id.quantity_salt).text = getString(labelqtySalt)



            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle).background,
                ColorStateList.valueOf(context.getColor(colorFat))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_salt).background,
                ColorStateList.valueOf(context.getColor(colorSalt))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_satured_acid).background,
                ColorStateList.valueOf(context.getColor(colorAcid))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_sugar).background,
                ColorStateList.valueOf(context.getColor(colorSugar))
            )
        }

        return view
    }
}