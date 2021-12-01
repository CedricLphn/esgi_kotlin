package fr.leprohon.labs.esgi_kotlin.databases

data class NutritionFacts(
    val energy: NutritionFactsItem,
    val matiere_g: NutritionFactsItem,
    val acide_gras_saturee: NutritionFactsItem,
    val glucid: NutritionFactsItem,
    val sugar: NutritionFactsItem,
    val fiber: NutritionFactsItem,
    val protein: NutritionFactsItem,
    val sel: NutritionFactsItem,
    val sodium: NutritionFactsItem
)