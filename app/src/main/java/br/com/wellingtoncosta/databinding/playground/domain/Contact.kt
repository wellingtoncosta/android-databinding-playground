package br.com.wellingtoncosta.databinding.playground.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author WellingtonCosta on 18/07/18
 */
@Entity(tableName = "contact")
data class Contact(
        @PrimaryKey(autoGenerate = true) var id: Int? = null,
        @ColumnInfo var name: String = "",
        @ColumnInfo var email: String = "",
        @ColumnInfo var phone: String = ""
)