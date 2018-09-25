package com.github.pgycode.account

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity : AppCompatActivity() {

    lateinit var observable: Observable<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        observable = Observable.create {
            emitter ->
            emitter.onNext("123")
            emitter.onNext("1234")
            emitter.onNext("12345")
        }

        observable.subscribe(object: Observer<String>{

            override fun onComplete() {
                println("onComplete")
            }

            override fun onNext(t: String) {
                println(t)
            }

            override fun onError(e: Throwable) {
                println(e.message)
            }

            override fun onSubscribe(d: Disposable) {
                println("开始了")
            }

        })

    }

}


