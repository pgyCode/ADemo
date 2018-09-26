package com.github.pgycode.account

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import android.widget.Toast
import com.github.pgycode.account.vm.LoginViewModel

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login_activity.*

class Login1Activity : Activity() {

    val vm: LoginViewModel = LoginViewModel()

    lateinit var observable: Observable<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        observable = vm.getLoginObservable("123456", "123456");

        observable?.subscribe(object : Observer<Int> {

            override fun onNext(t: Int) {
                if (t == 2){
                    Toast.makeText(this@Login1Activity, "登录成功", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onSubscribe(d: Disposable) {
                loading.visibility = View.VISIBLE
            }

            override fun onError(e: Throwable) {
                Toast.makeText(this@Login1Activity, "登录失败", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                loading.visibility = View.GONE
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        observable.unsubscribeOn(Schedulers.io())
    }
}
