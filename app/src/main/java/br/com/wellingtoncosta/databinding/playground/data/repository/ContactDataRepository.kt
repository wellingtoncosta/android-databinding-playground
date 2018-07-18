package br.com.wellingtoncosta.databinding.playground.data.repository

import br.com.wellingtoncosta.databinding.playground.data.room.ContactDao
import br.com.wellingtoncosta.databinding.playground.domain.Contact
import javax.inject.Inject

/**
 * @author WellingtonCosta on 18/07/18
 */
class ContactDataRepository @Inject constructor(
        private val dao: ContactDao
) : ContactRepository {

    override fun insert(contact: Contact) = dao.insert(contact)

    override fun listAll() = dao.listAll()

}