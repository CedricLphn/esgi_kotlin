package fr.leprohon.labs.esgi_kotlin.presentation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import fr.leprohon.labs.esgi_kotlin.R

class NutrientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nutrients)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        DrawableCompat.setTintList(
            findViewById<View>(R.id.circle).background,
            ColorStateList.valueOf(getColor(R.color.nutrient_level_low))
        )
        DrawableCompat.setTintList(
            findViewById<View>(R.id.circle_salt).background,
            ColorStateList.valueOf(getColor(R.color.nutrient_level_low))
        )
        DrawableCompat.setTintList(
            findViewById<View>(R.id.circle_satured_acid).background,
            ColorStateList.valueOf(getColor(R.color.nutrient_level_moderate))
        )
        DrawableCompat.setTintList(
            findViewById<View>(R.id.circle_sugar).background,
            ColorStateList.valueOf(getColor(R.color.nutrient_level_moderate))
        )


    }
}