package br.com.wellingtoncosta.databinding.playground.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.wellingtoncosta.databinding.playground.R
import br.com.wellingtoncosta.databinding.playground.databinding.ActivityListContactsBinding
import br.com.wellingtoncosta.databinding.playground.ui.Constants.LIST_CONTACTS_ACTIVITY
import br.com.wellingtoncosta.databinding.playground.ui.Constants.START_NEW_CONTACT_ACTIVITY
import br.com.wellingtoncosta.databinding.playground.ui.RxBus
import br.com.wellingtoncosta.databinding.playground.ui.create.NewContactActivity
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.functions.Consumer
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration

/**
 * @author WellingtonCosta on 18/07/18
 */
class ListContactsActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityListContactsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ListContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_contacts)
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(ListContactsViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        setupRecyclerView()

        observeContacts()
        observeHasError()
        observeEvents()
    }

    override fun onResume() {
        super.onResume()
        viewModel.listAll()
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.unregister(this)
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(
                recyclerView.context,
                layoutManager.orientation
        )

        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(divider)
    }

    private fun observeContacts() {
        viewModel.contacts.observe(this, Observer {
            val contacts = it ?: emptyList()
            binding.recyclerView.adapter = ListContactsAdapter(contacts)
        })
    }

    private fun observeHasError() {
        viewModel.hasError.observe(this, Observer {
            val hasError = it ?: false
            if(hasError) {
                Toast.makeText(
                        this,
                        R.string.load_contacts_failure,
                        Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun observeEvents() {
        RxBus.subscribe(LIST_CONTACTS_ACTIVITY, this, Consumer {
            when(it.toString()) {
                START_NEW_CONTACT_ACTIVITY -> startNewContactActivity()
            }
        })
    }

    private fun startNewContactActivity() {
        startActivity(Intent(this, NewContactActivity::class.java))
    }

}