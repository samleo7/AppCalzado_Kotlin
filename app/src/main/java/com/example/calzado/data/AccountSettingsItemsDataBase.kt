package com.example.calzado.data

import android.content.Context
import com.example.calzado.R
import com.example.calzado.domain.AccountSettingItem
import com.example.calzado.view.config.connectiondata.ConnectDataActivity
import com.example.calzado.view.config.creditcard.CreditCardsActivity
import com.example.calzado.view.config.deliveryaddress.DeliveryAddressesActivity
import com.example.calzado.view.config.profile.ProfileActivity

class AccountSettingsItemsDataBase {
    companion object{

        fun getItems( context: Context)
                = listOf(
                AccountSettingItem(
                        context.getString( R.string.setting_item_profile ),
                        context.getString( R.string.setting_item_profile_desc ),
                        ProfileActivity::class.java
                ),
                AccountSettingItem(
                        context.getString( R.string.setting_item_login ),
                        context.getString( R.string.setting_item_login_desc ),
                        ConnectDataActivity::class.java
                ),
                AccountSettingItem(
                        context.getString( R.string.setting_item_address ),
                        context.getString( R.string.setting_item_address_desc ),
                        DeliveryAddressesActivity::class.java
                ),
                AccountSettingItem(
                        context.getString( R.string.setting_item_credit_cards ),
                        context.getString( R.string.setting_item_credit_cards_desc ),
                        CreditCardsActivity::class.java
                )
        )
    }
}