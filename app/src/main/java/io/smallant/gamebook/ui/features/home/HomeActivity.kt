package io.smallant.gamebook.ui.features.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.smallant.gamebook.R
import io.smallant.gamebook.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity<HomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = HomeRecyclerAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        getViewModel().cardsList.observe(this, Observer { result ->
            Log.d("RoomLog", "fetching = $result")
            adapter.setItems(result, true)
        })

        fab_add.setOnClickListener {
            getViewModel().saveCards()
        }
    }
}
