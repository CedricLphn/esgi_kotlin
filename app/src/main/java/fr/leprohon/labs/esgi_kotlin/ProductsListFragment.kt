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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.leprohon.labs.esgi_kotlin.databases.product_fake
import fr.leprohon.labs.esgi_kotlin.presentation.productslist.ProductsAdapter

class ProductsListFragment : Fragment() {

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
            adapter = ProductsAdapter(listOf(product_fake))
            addItemDecoration(
                DividerItemDecoration(
                    this@ProductsListFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        view.findViewById<Button>(R.id.products_start_scan).setOnClickListener {
            Log.i("", "onViewCreated: click")
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

                Log.i("", res.toString())
            }
            Activity.RESULT_CANCELED -> {
                Log.i("BarcodeScanner", "Activity: Barcode scan cancelled")
            }
        }
    }
}