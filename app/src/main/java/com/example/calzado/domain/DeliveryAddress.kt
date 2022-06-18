package com.example.calzado.domain

import android.content.Context
import android.os.Parcelable
import com.example.calzado.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class DeliveryAddress (
    val street: String,
    val number: Int,
    val complement: String,
    val zipCode: String,
    val neighborhood: String,
    val city: String,
    val state: Int ) : Parcelable {

    fun getStateName( context: Context)
        = context
            .resources
            .getStringArray( R.array.states )[ state ]

    companion object {
        const val KEY = "delivery-address-key"
    }

}