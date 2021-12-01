package fr.leprohon.labs.esgi_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.leprohon.labs.esgi_kotlin.databases.Product

class SharedProductView: ViewModel() {
    val selected = MutableLiveData<Product>()

    fun select(product: Product) {
        selected.value = product
    }
}