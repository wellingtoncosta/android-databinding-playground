package br.com.wellingtoncosta.databinding.playground.di.module

import br.com.wellingtoncosta.databinding.playground.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.arch.persistence.room.Room
import android.content.Context


/**
 * @author WellingtonCosta on 18/07/18
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "app-db").build()

}