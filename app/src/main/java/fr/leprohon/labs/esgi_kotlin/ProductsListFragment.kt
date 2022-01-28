package fr.leprohon.labs.esgi_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.leprohon.labs.esgi_kotlin.databases.Product
import fr.leprohon.labs.esgi_kotlin.databases.product_fake
import fr.leprohon.labs.esgi_kotlin.presentation.productslist.ProductsAdapter

class ProductsListFragment : Fragment() {

    private val products : MutableList<Product> = mutableListOf(product_fake)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.main_list).run {
            layoutManager = LinearLayoutManager(this@ProductsListFragment.context)
            adapter = ProductsAdapter(products)
            addItemDecoration(
                DividerItemDecoration(
                    this@ProductsListFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        view.findViewById<Button>(R.id.products_start_scan).setOnClickListener {
            val intent = Intent()
            intent.action = "com.google.zxing.client.android.SCAN"
            intent.putExtra("SCAN_FORMATS", "EAN_13")
            getBarcode.launch(intent)
        }

    }

    private val getBarcode = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        when(it.resultCode) {
            Activity.RESULT_OK -> {
                val res = it.data?.getStringExtra("SCAN_RESULT")
                products.add(product_fake)
                val product : Product = product_fake
                product.barcode = res.toString()
                Log.i("", res.toString())
                val bundle = bundleOf("product" to product)
                this.findNavController()
                    .navigate(R.id.action_productsListFragment_to_productDetailsFragment, bundle)
            }
            Activity.RESULT_CANCELED -> {
                Log.i("BarcodeScanner", "Activity: Barcode scan cancelled")
            }
        }
    }
}