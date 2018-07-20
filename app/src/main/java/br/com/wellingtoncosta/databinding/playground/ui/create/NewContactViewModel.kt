package br.com.wellingtoncosta.databinding.playground.ui.create

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wellingtoncosta.databinding.playground.data.room.ContactDao
import br.com.wellingtoncosta.databinding.playground.domain.Contact
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author WellingtonCosta on 20/07/18
 */
class NewContactViewModel @Inject constructor(
        private val contactDao: ContactDao
) : ViewModel() {

    private lateinit var disposable: Disposable

    val isSaving: MutableLiveData<Boolean> = MutableLiveData()

    val wasSaved: MutableLiveData<Boolean> = MutableLiveData()

    val hasError: MutableLiveData<Boolean> = MutableLiveData()

    fun saveContact(contact: Contact) {
        disposable = Observable
                .fromCallable { contactDao.insert(contact) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isSaving.value = true }
                .doAfterTerminate { isSaving.value = false }
                .subscribe(
                        { wasSaved.value = true },
                        { hasError.value = true ; wasSaved.value = false }
                )
    }

    override fun onCleared() {
        super.onCleared()
        if(!disposable.isDisposed) {
            disposable.dispose()
        }
    }

}