package com.sprout.base;


import com.sprout.interfaces.IBasePresenter;
import com.sprout.interfaces.IBaseView;

import java.lang.ref.WeakReference;

/**
 * p层的基类
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;
    //通过弱引用把V层关联
    WeakReference<V> weakReference;


    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unAttachView() {
        mView = null;
    }

}
