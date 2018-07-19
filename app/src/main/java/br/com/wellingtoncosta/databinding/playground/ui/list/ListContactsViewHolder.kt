package br.com.wellingtoncosta.databinding.playground.ui.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.wellingtoncosta.databinding.playground.databinding.ListContactItemBinding

/**
 * @author WellingtonCosta on 19/07/18
 */
class ListContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListContactItemBinding? = DataBindingUtil.bind(view)

}