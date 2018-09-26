package com.github.pgycode.account

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity : AppCompatActivity() {

    lateinit var observable: Observable<Drawable>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        observable.subscribe(object: Observer<Drawable?>{

            override fun onComplete() {
                println("onComplete")
            }

            override fun onNext(t: Drawable) {
                println(Thread.currentThread().toString())
                imgIcon.setImageDrawable(t)
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