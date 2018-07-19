package br.com.wellingtoncosta.databinding.playground.ui.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wellingtoncosta.databinding.playground.data.repository.ContactRepository
import br.com.wellingtoncosta.databinding.playground.domain.Contact
import br.com.wellingtoncosta.databinding.playground.ui.Constants.LIST_CONTACTS_ACTIVITY
import br.com.wellingtoncosta.databinding.playground.ui.Constants.START_NEW_CONTACT_ACTIVITY
import br.com.wellingtoncosta.databinding.playground.ui.RxBus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author WellingtonCosta on 18/07/18
 */
class ListContactsViewModel @Inject constructor(
        private val contactRepository: ContactRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val contacts: MutableLiveData<List<Contact>> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    val hasError: MutableLiveData<Boolean> = MutableLiveData()

    fun listAll() {
        compositeDisposable.add(contactRepository.listAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doAfterTerminate { isLoading.value = false }
                .subscribe(
                        { contacts.value = it; hasError.value = false },
                        { hasError.value = true }
                )
        )
    }

    fun startNewContactActivity() {
        RxBus.publish(LIST_CONTACTS_ACTIVITY, START_NEW_CONTACT_ACTIVITY)
    }

    override fun onCleared() {
        if(!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}