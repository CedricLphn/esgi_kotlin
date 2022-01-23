package fr.leprohon.labs.esgi_kotlin

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso
import fr.leprohon.labs.esgi_kotlin.utils.formatItemsFromList

class ProductDetailsSummaryFragment : Fragment() {
    private val model: SharedProductView by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_product_details_summary, container, false)
        val product = model.selected.value!!
        val posterView = view.findViewById<ImageView>(R.id.posterView)
        Picasso.get()
            .load(product.imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(posterView)

        with(view) {
            findViewById<TextView>(R.id.title).text = product.name
            findViewById<TextView>(R.id.brand).text = product.brand

            findViewById<TextView>(R.id.barcode).text = setTextStyle(getString(R.string.barcode), product.barcode)
            findViewById<TextView>(R.id.quantity).text = setTextStyle(getString(R.string.quantity), product.quantity)
            findViewById<TextView>(R.id.sold).text = setTextStyle(getString(R.string.sold), product.country.formatItemsFromList())
            findViewById<TextView>(R.id.ingredients).text = setTextStyle(getString(R.string.quantity), product.quantity)
            findViewById<TextView>(R.id.allergenes).text = setTextStyle(getString(R.string.allergenes), product.allergen)
            findViewById<TextView>(R.id.additives).text = setTextStyle(getString(R.string.additives), product.additives)
        }

        return view
    }

    private fun setTextStyle(label : String, content : String) : SpannableStringBuilder {
        return SpannableStringBuilder()
            .bold { append("$label: ") }
            .append(content)
    }
}