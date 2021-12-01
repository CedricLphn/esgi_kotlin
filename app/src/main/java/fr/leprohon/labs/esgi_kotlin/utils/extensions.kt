package fr.leprohon.labs.esgi_kotlin.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.Executors

fun TextView.setSpannableTextBold(text: String, separator: String = ":") {
    val builder = SpannableStringBuilder(text)
    builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
    setText(builder)
}

fun List<String>.formatItemsFromList() : String{
    return this.toString().substring(1, this.toString().length-1)
}