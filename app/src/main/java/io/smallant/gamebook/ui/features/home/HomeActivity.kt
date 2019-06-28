package io.smallant.gamebook.ui.features.home

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        swipeToDelete()

        getViewModel().cardsList.observe(this, Observer { result ->
            adapter.setItems(result, true)
        })

        fab_add.setOnClickListener {
            getViewModel().saveCards()
        }
    }

    private fun swipeToDelete() {
        val itemTouchHelper = ItemTouchHelper(object:ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                if (viewHolder is HomeRecyclerAdapter.HomeViewHolder) {
                    val swipeFlags = ItemTouchHelper.END
                    return makeMovementFlags(0, swipeFlags)
                }
                return 0
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if(viewHolder is HomeRecyclerAdapter.HomeViewHolder){
                    val adapter = recycler.adapter as HomeRecyclerAdapter
                    getViewModel().deleteCard(adapter.items[viewHolder.adapterPosition].id)
                    Toast.makeText(this@HomeActivity, "Item deleted", Toast.LENGTH_SHORT).show()
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(recycler)
    }
}
