package fr.leprohon.labs.esgi_kotlin.databases

data class NutritionFactsItem(
    val units: String,
    val quantityfor100g: Double,
    val quantityperportion: Int
)