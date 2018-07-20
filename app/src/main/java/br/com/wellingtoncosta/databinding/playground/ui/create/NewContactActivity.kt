package br.com.wellingtoncosta.databinding.playground.ui.create

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import br.com.wellingtoncosta.databinding.playground.R
import br.com.wellingtoncosta.databinding.playground.databinding.ActivityNewContactBinding
import br.com.wellingtoncosta.databinding.playground.domain.Contact
import convalida.annotations.OnValidationSuccess
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @author WellingtonCosta on 18/07/18
 */
class NewContactActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityNewContactBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_contact)
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(NewContactViewModel::class.java)

        binding.viewModel = viewModel
        binding.contact = Contact(id = null, name = "", email = "", phone = "")
        binding.setLifecycleOwner(this)

        setupToolbar()

        NewContactActivityFieldsValidation.init(this, binding)

        observeWasSaved()
        observeHasError()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.includeToolbar?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.includeToolbar?.toolbar?.setNavigationOnClickListener { finish() }
    }

    @OnValidationSuccess
    fun contactSaved() {
        binding.contact?.let { viewModel.saveContact(it) }
    }

    private fun observeWasSaved() {
        viewModel.wasSaved.observe(this, Observer {
            it?.let { if(it) { finish() } }
        })
    }

    private fun observeHasError() {
        viewModel.hasError.observe(this, Observer {
            Toast.makeText(this, R.string.save_failure, Toast.LENGTH_LONG)
                    .show()
        })
    }

}