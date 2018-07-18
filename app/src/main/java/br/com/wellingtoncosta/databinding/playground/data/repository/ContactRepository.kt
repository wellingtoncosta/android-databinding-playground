package br.com.wellingtoncosta.databinding.playground.data.repository

import br.com.wellingtoncosta.databinding.playground.domain.Contact
import io.reactivex.Flowable

/**
 * @author WellingtonCosta on 18/07/18
 */
interface ContactRepository {

    fun insert(contact: Contact)

    fun listAll(): Flowable<List<Contact>>

}