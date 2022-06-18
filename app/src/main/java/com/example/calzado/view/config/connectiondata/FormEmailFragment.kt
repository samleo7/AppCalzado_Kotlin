package com.example.calzado.view.config.connectiondata

import android.os.Bundle
import com.example.calzado.R
import com.example.calzado.util.isValidEmail
import com.example.calzado.util.validate
import com.example.calzado.view.config.ConfigFormFragment
import kotlinx.android.synthetic.main.fragment_config_email.*

class FormEmailFragment :
        ConfigFormFragment() {

    override fun title()
            = R.string.config_connection_data_tab_email

    override fun getLayoutResourceID()
            = R.layout.fragment_config_email

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        bt_update_email_login.setOnClickListener{
            callPasswordDialog()
        }

        et_current_email.validate(
                {
                    it.isValidEmail()
                },
                getString( R.string.invalid_email )
        )

        et_new_email.validate(
                {
                    it.isValidEmail()
                },
                getString( R.string.invalid_email )
        )

        et_new_email_confirm.validate(
                {
                    /*
                     * O toString() em et_new_email.text.toString() é
                     * necessário, caso contrário a validação falha
                     * mesmo quando é para ser ok.
                     * */
                    (et_new_email.text.isNotEmpty()
                            && it.equals( et_new_email.text.toString() ))
                            || et_new_email.text.isEmpty()
                },
                getString( R.string.invalid_confirmed_email )
        )

        et_new_email_confirm.setOnEditorActionListener( this )
    }

    override fun backEndFakeDelay(){
        backEndFakeDelay(
                false,
                getString( R.string.invalid_sign_up_email )
        )
    }

    override fun blockFields( status: Boolean ){
        et_current_email.isEnabled = !status
        et_new_email.isEnabled = !status
        et_new_email_confirm.isEnabled = !status
        bt_update_email_login.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_update_email_login.text =
                if( status )
                    getString( R.string.update_email_login_going )
                else
                    getString( R.string.update_email_login )
    }
}