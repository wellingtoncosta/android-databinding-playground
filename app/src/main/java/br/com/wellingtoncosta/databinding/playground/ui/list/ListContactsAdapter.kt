package br.com.wellingtoncosta.databinding.playground.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.wellingtoncosta.databinding.playground.R
import br.com.wellingtoncosta.databinding.playground.domain.Contact

/**
 * @author WellingtonCosta on 18/07/18
 */
class ListContactsAdapter(
        var contacts: List<Contact>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListContactsViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListContactsViewHolder).binding
        binding?.contact = contacts[position]
        binding?.executePendingBindings()
    }

    override fun getItemCount() = contacts.size

}