package com.example.calzado.view.config.deliveryaddress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calzado.R
import com.example.calzado.view.config.ConfigFormFragment

/*
 * Fragmento com responsabilidade de ser o fragmento
 * host de mais de um fragmento e assim permitir a
 * fácil alternância de fragmentos dentro de uma mesma
 * tela de ViewPager.
 * */
class DeliveryAddressHostFragment
    : ConfigFormFragment() {

    override fun title()
            = DeliveryAddressesListFragment.TAB_TITLE

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle? ): View? {

        /*
         * É preciso inflar o layout que vai conter
         * os fragmentos.
         * */
        val view = inflater
                .inflate(
                        R.layout.fragment_config_delivery_address_host,
                        container,
                        false
                )

        /*
         * Somente na primeira abertura é que a regra de
         * fragmento inicial, do bloco condicional a seguir,
         * deve ser seguida.
         * */
        if( savedInstanceState == null ){
            val transaction = requireActivity()   //  activity!!
                    .supportFragmentManager!!
                    .beginTransaction()

            /*
             * Então, aqui no fragmento root (container),
             * iniciamos com o primeiro fragmento via
             * FragmentTransaction e sem trabalho com pilha
             * de fragmentos.
             * */
            transaction
                    .replace(
                            R.id.fl_root,
                            DeliveryAddressesListFragment()
                    )
                    .commit()
        }

        return view
    }

    override fun getLayoutResourceID() = 0

    override fun backEndFakeDelay() {}

    override fun blockFields(status: Boolean) {}

    override fun isMainButtonSending(status: Boolean) {}
}