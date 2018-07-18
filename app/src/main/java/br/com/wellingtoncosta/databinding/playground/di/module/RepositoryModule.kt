package br.com.wellingtoncosta.databinding.playground.di.module

import br.com.wellingtoncosta.databinding.playground.data.repository.ContactDataRepository
import br.com.wellingtoncosta.databinding.playground.data.repository.ContactRepository
import dagger.Binds
import dagger.Module

/**
 * @author WellingtonCosta on 18/07/18
 */
@Module
interface RepositoryModule {

    @Binds
    fun bindContactRepository(imp: ContactDataRepository): ContactRepository

}