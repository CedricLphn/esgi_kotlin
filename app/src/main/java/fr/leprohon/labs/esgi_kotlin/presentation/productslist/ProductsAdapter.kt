package fr.leprohon.labs.esgi_kotlin.presentation.productslist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.adapters.ProgressBarBindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.leprohon.labs.esgi_kotlin.ProductDetailsFragment
import fr.leprohon.labs.esgi_kotlin.ProductDetailsNutritionFragment
import fr.leprohon.labs.esgi_kotlin.R
import fr.leprohon.labs.esgi_kotlin.databases.Product
import fr.leprohon.labs.esgi_kotlin.databinding.ProductItemBinding
import fr.leprohon.labs.esgi_kotlin.presentation.DetailActivity

class ProductsAdapter(private var products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        with(holder.binding) {

            productItem.setOnClickListener {
                val bundle = bundleOf("product" to product)
                holder.itemView.findNavController()
                    .navigate(R.id.action_productsListFragment_to_productDetailsFragment, bundle)
            }

            Picasso.get()
                .load(product.imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imageView);

            productName2.text = product.name

            brand.text = product.brand
            nutri.text = "Nutriscore A"
            cal.text =
                product.nutritionFactsItem.energy.quantityfor100g.toString() + product.nutritionFactsItem.energy.units

        }
    }

    override fun getItemCount(): Int = products.size


}