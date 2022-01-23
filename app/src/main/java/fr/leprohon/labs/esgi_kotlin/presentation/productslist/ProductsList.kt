package fr.leprohon.labs.esgi_kotlin.presentation.productslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.leprohon.labs.esgi_kotlin.databases.Product
import fr.leprohon.labs.esgi_kotlin.databases.product_fake
import fr.leprohon.labs.esgi_kotlin.databinding.ActivityProductsListBinding

class ProductsList : AppCompatActivity() {

    private lateinit var binding: ActivityProductsListBinding
    private lateinit var adapter: ProductsAdapter
    private val products = listOf<Product>(product_fake, product_fake)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductsAdapter(products)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}