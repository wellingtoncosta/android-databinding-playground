package br.com.wellingtoncosta.databinding.playground.ui.list

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.wellingtoncosta.databinding.playground.R
import br.com.wellingtoncosta.databinding.playground.databinding.ActivityListContactsBinding

/**
 * @author WellingtonCosta on 18/07/18
 */
class ListContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_contacts)
    }

}