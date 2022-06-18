package com.example.calzado.view.config.connectiondata

import com.example.calzado.view.config.ConfigFormActivity
import com.example.calzado.view.config.ConfigSectionsAdapter

class ConnectDataActivity :
        ConfigFormActivity() {

    override fun getSectionsAdapter()
            = ConfigSectionsAdapter(
            this,
            supportFragmentManager,
            FormEmailFragment(),
            FormPasswordFragment()
    )
}