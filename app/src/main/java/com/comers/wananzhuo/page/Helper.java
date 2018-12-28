package com.comers.wananzhuo.page;

import android.util.Log;
import com.comers.wananzhuo.base.presenter.BasePresenter;

/**
 * Created by 79653 on 2018/12/27.
 * 描述：
 */
public class Helper {
    public <T extends BasePresenter> boolean getData(T t) {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("autoDispose","------------"+(t==null)+"--------");
            return t == null;
        }
        return t == null;
    }
}
