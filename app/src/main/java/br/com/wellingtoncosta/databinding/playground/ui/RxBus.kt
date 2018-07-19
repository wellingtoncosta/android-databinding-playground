package br.com.wellingtoncosta.databinding.playground.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject

/**
 * @author WellingtonCosta on 19/07/18
 */
object RxBus {

    private val subjectMap = HashMap<String, PublishSubject<Any>>()
    private val subscriptionsMap = HashMap<Any, CompositeDisposable>()

    private fun getSubject(subjectKey: String): PublishSubject<Any> {
        var subject = subjectMap.get(subjectKey)
        if(subject == null) {
            subject = PublishSubject.create()
            subject.subscribeOn(AndroidSchedulers.mainThread())
            subjectMap[subjectKey] = subject
        }
        return subject
    }

    private fun getCompositeDisposable(`object`: Any): CompositeDisposable {
        var compositeDisposable = subscriptionsMap[`object`]
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
            subscriptionsMap[`object`] = compositeDisposable
        }
        return compositeDisposable
    }

    fun subscribe(subject: String, lifecycle: Any, action: Consumer<Any>) {
        val disposable = getSubject(subject).subscribe(action)
        getCompositeDisposable(lifecycle).add(disposable)
    }

    fun unregister(lifecycle: Any) {
        subscriptionsMap.remove(lifecycle)?.dispose()
    }

    fun publish(subject: String, message: Any) {
        getSubject(subject).onNext(message)
    }

}