package br.com.wellingtoncosta.databinding.playground.di.module.data

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

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "app-db").build()

    @Provides
    @Singleton
    fun provideContactDao(appDatabase: AppDatabase) = appDatabase.contactDao()

}