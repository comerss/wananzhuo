package com.comers.wananzhuo.page;

import android.os.Handler;

/**
 * Created by 79653 on 2018/12/27.
 * 描述：
 */
public  class JavaActivity  implements MainInterfaces.MainView {

    @Override
    public void showView() {

    }
    public static void main(String[] args){
        final MainPresenter[] presenter = {new MainPresenter(new MainInterfaces.MainView() {
            @Override
            public void showView() {
                
            }
        })};
        new Helper().getData(presenter[0]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter[0] =null;
            }
        }, 5000);
    }
}
