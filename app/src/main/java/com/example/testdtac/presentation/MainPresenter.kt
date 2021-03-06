package com.example.testdtac.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import com.example.testdtac.data.DataModule
import com.example.testdtac.data.SearchResponse
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainPresenter {
    @SuppressLint("CheckResult")
    fun getSearch() {

        DataModule.instance()!!.getSearchResult()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<SearchResponse>() {
                override fun onComplete() {

                }

                override fun onNext(t: SearchResponse) {
                }

                override fun onError(e: Throwable) {

                }
            })


}
}