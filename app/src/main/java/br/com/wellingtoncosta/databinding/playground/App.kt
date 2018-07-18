package br.com.wellingtoncosta.databinding.playground

import br.com.wellingtoncosta.databinding.playground.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @author WellingtonCosta on 18/07/18
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().create(this)
    }

}