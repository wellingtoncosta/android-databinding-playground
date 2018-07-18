package br.com.wellingtoncosta.databinding.playground.ui.create

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.wellingtoncosta.databinding.playground.R
import br.com.wellingtoncosta.databinding.playground.databinding.ActivityNewContactBinding

/**
 * @author WellingtonCosta on 18/07/18
 */
class NewContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_contact)
    }

}