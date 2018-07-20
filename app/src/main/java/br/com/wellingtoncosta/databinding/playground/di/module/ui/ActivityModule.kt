package br.com.wellingtoncosta.databinding.playground.di.module.ui

import br.com.wellingtoncosta.databinding.playground.ui.create.NewContactActivity
import br.com.wellingtoncosta.databinding.playground.ui.list.ListContactsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author WellingtonCosta on 18/07/18
 */
@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun contributeListContactsActivity(): ListContactsActivity

    @ContributesAndroidInjector
    fun contributeNewContactActivity(): NewContactActivity

}