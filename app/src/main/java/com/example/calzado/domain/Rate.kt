package com.example.calzado.domain

import com.example.calzado.R
import kotlin.math.ceil
import kotlin.math.floor

class Rate (
    private val stars: Float,
    private val numCommets: Int
    ) {
    fun getNumCommentsLabel()
    = String.format("%d", numCommets)

    fun getStarResource( starPosition : Int )
            = if( starPosition <= floor( stars ).toInt() )
        R.drawable.ic_star_filled
    else if( starPosition == ceil( stars ).toInt() )
        R.drawable.ic_star_half_empty
    else
        R.drawable.ic_star_empty
}