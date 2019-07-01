package io.smallant.gamebook.ui.features.home

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import io.smallant.gamebook.ui.extensions.isNotNull

class HomeRecyclerItemTouchHelper(dragDirs: Int, swipeDirs: Int, private val listener: HomeRecyclerItemToucheHelperListener): ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if(viewHolder.isNotNull()) {
            val foregroundView = (viewHolder as HomeRecyclerAdapter.HomeViewHolder).viewForeground
            getDefaultUIUtil().onSelected(foregroundView)
        }
    }

    override fun onChildDrawOver(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        val foregroundView = (viewHolder as HomeRecyclerAdapter.HomeViewHolder).viewForeground
        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val foregroundView = (viewHolder as HomeRecyclerAdapter.HomeViewHolder).viewForeground
        getDefaultUIUtil().clearView(foregroundView)
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        val foregroundView = (viewHolder as HomeRecyclerAdapter.HomeViewHolder).viewForeground
        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder, direction, viewHolder.adapterPosition)
    }

    interface HomeRecyclerItemToucheHelperListener {
        fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int)
    }

}