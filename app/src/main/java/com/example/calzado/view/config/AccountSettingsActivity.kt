package com.example.calzado.view.config

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calzado.R
import com.example.calzado.data.AccountSettingsItemsDataBase
import com.example.calzado.domain.User
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_account_settings.*

class AccountSettingsActivity : AppCompatActivity() {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_account_settings )
        setSupportActionBar( toolbar )

        /*
         * Para liberar o back button na barra de topo da
         * atividade.
         * */
        supportActionBar?.setDisplayHomeAsUpEnabled( true )
        supportActionBar?.setDisplayShowHomeEnabled( true )

        /*
         * Colocando em tela o usuário conectado.
         * */
        val user = getUser()
        tv_user_connected.text = String.format(
            "%s %s",
            getString(R.string.connected),
            user?.name   // se agrego ?
        )

        initItems()
    }

    /*
     * Método que permitirá o acesso ao User em Intent
     * também por parte de outros objetos dependentes de
     * AccountSettingsActivity.
     * */
    fun getUser()
            = intent.getParcelableExtra<User>( User.KEY )

    override fun onOptionsItemSelected( item: MenuItem): Boolean {
        if( item.itemId == android.R.id.home ){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /*
     * Método que inicializa a lista de itens de configurações
     * de conta.
     * */
    private fun initItems(){
        rv_account_settings_items.setHasFixedSize( false )

        val layoutManager = LinearLayoutManager( this )
        rv_account_settings_items.layoutManager = layoutManager

        val divider = DividerItemDecoration(
            this,
            layoutManager.getOrientation()
        )
        divider.setDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.light_grey_divider_line
            )!!
        )
        rv_account_settings_items.addItemDecoration( divider )

        rv_account_settings_items.adapter = AccountSettingsListAdapter(
            AccountSettingsItemsDataBase.getItems(this)
        )
    }
}