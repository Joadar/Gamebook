package io.smallant.gamebook.ui.features.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.smallant.gamebook.R
import io.smallant.gamebook.data.models.Card
import io.smallant.gamebook.ui.base.BaseRecyclerAdapter
import io.smallant.gamebook.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_home_card.view.*

class HomeRecyclerAdapter: BaseRecyclerAdapter<Card>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Card> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(layoutInflater.inflate(R.layout.item_home_card, parent, false))
    }

    class HomeViewHolder(itemView: View): BaseViewHolder<Card>(itemView) {
        override fun bind(item: Card, position: Int) {
            with(itemView) {
                label_left.text = item.id.toString()
                label_right.text = item.description
            }
        }
    }
}