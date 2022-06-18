package com.example.calzado.view.config.creditcard

import android.os.Bundle
import com.example.calzado.R
import com.example.calzado.data.CreditCardsDataBase
import com.example.calzado.view.config.ConfigListFragment
import kotlinx.android.synthetic.main.fragment_config_list.*

class CreditCardsListFragment :
        ConfigListFragment() {

    override fun title()
            = R.string.config_credit_cards_tab_list

    override fun backEndFakeDelay() {
        backEndFakeDelay(
                true,
                getString( R.string.credit_card_removed )
        )
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        tv_empty_list.setText( R.string.credit_card_list_empty )
    }

    override fun getRecyclerViewAdapter()
            = CreditCardsListAdapter(
            this,
            CreditCardsDataBase.getItems()
    )
}