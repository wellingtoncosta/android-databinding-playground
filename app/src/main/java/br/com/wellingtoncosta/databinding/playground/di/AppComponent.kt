package br.com.wellingtoncosta.databinding.playground.di

import br.com.wellingtoncosta.databinding.playground.App
import br.com.wellingtoncosta.databinding.playground.di.module.AppModule
import br.com.wellingtoncosta.databinding.playground.di.module.data.RepositoryModule
import br.com.wellingtoncosta.databinding.playground.di.module.data.RoomModule
import br.com.wellingtoncosta.databinding.playground.di.module.ui.ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author WellingtonCosta on 18/07/18
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    AppModule::class,
    RoomModule::class,
    RepositoryModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}