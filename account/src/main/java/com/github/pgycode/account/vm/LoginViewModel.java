package com.github.pgycode.account.vm;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel {

    public Observable<Integer> getLoginObservable(String name, String pass){
        return Observable.just(new LoginBean(name, pass))
                .observeOn(Schedulers.io())
                .map(new Function<LoginBean, Integer>() {
                    @Override
                    public Integer apply(LoginBean loginBean) throws Exception {
                        Thread.sleep(5000);
                        if (loginBean.name.equals("123456") && loginBean.pass.equals("123456")){
                            return 2;
                        }
                        new Throwable("登录失败");
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static class LoginBean{
        public String name;
        public String pass;

        public LoginBean(String name, String pass){
            this.name = name;
            this.pass = pass;
        }
    }
}
