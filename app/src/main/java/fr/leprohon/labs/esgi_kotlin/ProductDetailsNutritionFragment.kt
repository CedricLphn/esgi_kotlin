package fr.leprohon.labs.esgi_kotlin

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

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

        val view = inflater.inflate(R.layout.fragment_product_details_nutrition, container, false)

        with(view) {
            val colors : MutableMap<String, Int> = mutableMapOf()
            val labels : MutableMap<String, Int> = mutableMapOf()

            when {
                product.nutritionFactsItem.matiere_g.quantityfor100g < 3 -> {
                    colors["fat"] = R.color.nutrient_level_low
                    labels["fat"] = R.string.level_low
                }
                product.nutritionFactsItem.matiere_g.quantityfor100g in 3.0..20.0 -> {
                    colors["fat"] = R.color.nutrient_level_moderate
                    labels["fat"] = R.string.level_moderate
                }
                else -> {
                    colors["fat"] = R.color.nutrient_level_high
                    labels["fat"] = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.acide_gras_saturee.quantityfor100g < 1.5 -> {
                    colors["acid"] = R.color.nutrient_level_low
                    labels["acid"] = R.string.level_low
                }
                product.nutritionFactsItem.acide_gras_saturee.quantityfor100g in 1.5..5.0 -> {
                    colors["acid"] = R.color.nutrient_level_moderate
                    labels["acid"] = R.string.level_moderate
                }
                else -> {
                    colors["acid"] = R.color.nutrient_level_high
                    labels["acid"] = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.sugar.quantityfor100g < 5.0 -> {
                    colors["sugar"] = R.color.nutrient_level_low
                    labels["sugar"] = R.string.level_low
                }
                product.nutritionFactsItem.sugar.quantityfor100g in 5.0..12.5 -> {
                    colors["sugar"] = R.color.nutrient_level_moderate
                    labels["sugar"] = R.string.level_moderate
                }
                else -> {
                    colors["sugar"] = R.color.nutrient_level_high
                    labels["sugar"] = R.string.level_high
                }
            }

            when {
                product.nutritionFactsItem.sel.quantityfor100g < 0.5 -> {
                    colors["salt"] = R.color.nutrient_level_low
                    labels["salt"] = R.string.level_low
                }
                product.nutritionFactsItem.sel.quantityfor100g in 0.5..1.5 -> {
                    colors["salt"] = R.color.nutrient_level_moderate
                    labels["salt"] = R.string.level_moderate
                }
                else -> {
                    colors["salt"] = R.color.nutrient_level_high
                    labels["salt"] = R.string.level_high
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



            findViewById<TextView>(R.id.quantity_fat).text = getString(labels["fat"]!!)
            findViewById<TextView>(R.id.quantity_satured_acid).text = getString(labels["acid"]!!)
            findViewById<TextView>(R.id.quantity_sugar).text = getString(labels["sugar"]!!)
            findViewById<TextView>(R.id.quantity_salt).text = getString(labels["salt"]!!)



            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle).background,
                ColorStateList.valueOf(context.getColor(colors["fat"]!!))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_salt).background,
                ColorStateList.valueOf(context.getColor(colors["salt"]!!))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_satured_acid).background,
                ColorStateList.valueOf(context.getColor(colors["acid"]!!))
            )
            DrawableCompat.setTintList(
                findViewById<View>(R.id.circle_sugar).background,
                ColorStateList.valueOf(context.getColor(colors["sugar"]!!))
            )
        }

        return view
    }
}