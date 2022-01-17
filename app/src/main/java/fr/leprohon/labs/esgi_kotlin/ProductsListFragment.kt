package fr.leprohon.labs.esgi_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.leprohon.labs.esgi_kotlin.databases.product_fake
import fr.leprohon.labs.esgi_kotlin.databinding.ActivityProductsListBinding
import fr.leprohon.labs.esgi_kotlin.presentation.productslist.ProductsAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

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
            getBarcode.launch(intent);
        }

    }

    private val getBarcode = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        when(it.resultCode) {
            Activity.RESULT_OK -> {
                val format = it.data?.getStringExtra("SCAN_RESULT_FORMAT")
                val res = it.data?.getStringExtra("SCAN_RESULT")

                Log.i("", res.toString());
            }
            Activity.RESULT_CANCELED -> {
                Log.i("BarcodeScanner", "Activity: Barcode scan cancelled")
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductsListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}