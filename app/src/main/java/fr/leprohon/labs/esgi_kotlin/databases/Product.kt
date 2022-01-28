package fr.leprohon.labs.esgi_kotlin.databases

import java.io.Serializable

data class Product(
    val name: String,
    val brand: String,
    var barcode: String,
    val quantity: String,
    val country: ArrayList<String>,
    val ingredients: String,
    val allergen: String,
    val additives: String,
    var imageUrl: String,
    var nutritionFactsItem: NutritionFacts
) : Serializable

val nutritionFactsItem: NutritionFacts = NutritionFacts(
    NutritionFactsItem("kj", 293.0, 0),
    NutritionFactsItem("g", 8.3, 0),
    NutritionFactsItem("g", 0.1, 0),
    NutritionFactsItem("g", 8.4, 0),
    NutritionFactsItem("g", 5.2, 0),
    NutritionFactsItem("g", 5.2, 0),
    NutritionFactsItem("g", 4.2, 0),
    NutritionFactsItem("g", 0.75, 0),
    NutritionFactsItem("g", 0.295, 0)
)


val product_fake: Product = Product(
    "Petits pois et carottes",
    "Cassegrain",
    "3083680085304",
    "400 g (280 g net égoutté)",
    arrayListOf<String>("France", "Suisse", "Japon"),
    "Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel",
    "Aucune",
    "Aucun",
    "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
    nutritionFactsItem
)