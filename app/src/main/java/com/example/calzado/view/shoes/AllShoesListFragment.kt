package com.example.calzado.view.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calzado.view.MainActivity
import com.example.calzado.R
import com.example.calzado.data.AllShoesDataBase
import kotlinx.android.synthetic.main.fragment_all_shoes_list.*


class AllShoesListFragment : Fragment() {

    companion object{
        const val GRID_COLUMNS = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_shoes_list, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        initItems()
    }

    private fun initItems(){
        rv_shoes.setHasFixedSize( false )

        val layoutManager = GridLayoutManager(
                activity,
                GRID_COLUMNS,
                RecyclerView.VERTICAL,
                false
        )
        rv_shoes.layoutManager = layoutManager

        val adapter = AllShoesListAdapter( AllShoesDataBase.getItems() )
        rv_shoes.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity)
                .updateToolbarTitleInFragment( R.string.all_shoes_list_frag_title )
    }


}