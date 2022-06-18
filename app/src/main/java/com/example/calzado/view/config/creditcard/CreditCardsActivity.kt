package com.example.calzado.view.config.creditcard

import com.example.calzado.view.config.ConfigFormActivity
import com.example.calzado.view.config.ConfigSectionsAdapter

class CreditCardsActivity :
        ConfigFormActivity() {

    override fun getSectionsAdapter()
            = ConfigSectionsAdapter(
            this,
            supportFragmentManager,
            CreditCardsListFragment(),
            FormCreditCardFragment()
    )
}