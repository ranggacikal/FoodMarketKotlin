package com.ranggacikal.foodmarketkotlin

import android.widget.TextView
import java.text.DecimalFormat

object Helpers {

    fun TextView.formatPrice(value:String){

        this.text = getCurrencyIDR(value.toDouble())

    }

    fun getCurrencyIDR(price: Double) : String {
        val format = DecimalFormat("#,###,###")
        return "IDR"+format.format(price).replace(",".toRegex(), "")
    }

}