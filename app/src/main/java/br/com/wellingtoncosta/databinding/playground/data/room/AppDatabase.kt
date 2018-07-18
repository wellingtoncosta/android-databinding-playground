package br.com.wellingtoncosta.databinding.playground.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.wellingtoncosta.databinding.playground.domain.Contact

/**
 * @author WellingtonCosta on 18/07/18
 */
@Database(entities = [Contact::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        const val VERSION = 1
    }

}