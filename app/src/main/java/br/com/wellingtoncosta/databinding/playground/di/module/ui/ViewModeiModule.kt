package br.com.wellingtoncosta.databinding.playground.di.module.ui

import android.arch.lifecycle.ViewModel
import br.com.wellingtoncosta.databinding.playground.ui.create.NewContactViewModel
import br.com.wellingtoncosta.databinding.playground.ui.list.ListContactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import viewmodel.dagger.ViewModelFactoryModule
import viewmodel.dagger.ViewModelKey

/**
 * @author WellingtonCosta on 18/07/18
 */
@Module(includes = [ViewModelFactoryModule::class])
interface ViewModeiModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListContactsViewModel::class)
    fun bindListContactsViewModel(viewModel: ListContactsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewContactViewModel::class)
    fun bindNewContactViewModel(viewModel: NewContactViewModel): ViewModel

}