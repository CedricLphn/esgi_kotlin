package fr.leprohon.labs.esgi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.leprohon.labs.esgi_kotlin.databases.Product

class ProductDetailsFragment : Fragment() {

    private val model: SharedProductView by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(view.findViewById<BottomNavigationView>(R.id.product_details_bottom_nav), navHost.navController)

        val product = arguments?.getSerializable("product") as Product
        model.select(product)
    }
}