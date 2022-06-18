package com.example.calzado.view.config.deliveryaddress

import android.os.Bundle
import com.example.calzado.R
import com.example.calzado.domain.DeliveryAddress
import kotlinx.android.synthetic.main.fragment_config_new_delivery_address.*

class FormUpdateDeliveryAddressFragment :
        FormNewDeliveryAddressFragment() {

    override fun getLayoutResourceID()
            = R.layout.fragment_config_update_delivery_address

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        bt_nu_address.text = getString( R.string.update_delivery_address )

        bt_nu_address.setOnClickListener{
            callPasswordDialog()
        }

        fillForm()
    }

    private fun fillForm(){
        val address = requireArguments().getParcelable<DeliveryAddress>(   // arguments!!
                DeliveryAddress.KEY
        )

        et_street.setText( address!!.street )
        et_number.setText( address.number.toString() )
        et_complement.setText( address.complement )
        et_zip_code.setText( address.zipCode )
        et_neighborhood.setText( address.neighborhood )
        et_city.setText( address.city )
        sp_state.setSelection( address.state )
    }

    override fun backEndFakeDelay(){
        backEndFakeDelay(
                false,
                getString( R.string.invalid_delivery_address )
        )
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_address.text =
                if( status )
                    getString( R.string.update_delivery_address_going )
                else
                    getString( R.string.update_delivery_address )
    }
}