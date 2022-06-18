package com.example.calzado.domain

import android.content.Context
import com.example.calzado.R
import java.util.*

class Price (
    private val normal: Float,
    private val parcels: Int,
    val hasDiscount: Boolean,
    private val withDiscount:Float
    ) {

    fun getNormalLabel(context:Context)
    = String.format(
        Locale.GERMAN,
        "%s %.2f",
        context.getString(R.string.money_sign),
        normal
    )

    fun getWithDiscountLabel(context:Context)
            = String.format(
        Locale.GERMAN,
        "%s %.2f",
        context.getString(R.string.money_sign),
        withDiscount
    )

    fun getPercentDiscountLabel():String{
        val percent = ((withDiscount - normal)/normal) * 100

        return String.format("-%d%%", percent.toInt())
    }

    fun getParcelsLabel(context:Context):String{
        val priceParcel = if (hasDiscount)
            withDiscount / parcels
        else
            normal / parcels

        return String.format(
            Locale.GERMAN,
            "%s %dx %s %s %.2f",
            context.getString( R.string.in_until ),
            parcels,
            context.getString( R.string.of ),
            context.getString( R.string.money_sign ),
            priceParcel
            )
    }

}