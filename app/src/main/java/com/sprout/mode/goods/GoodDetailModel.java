package com.sprout.mode.goods;

import com.sprout.base.BaseModel;
import com.sprout.interfaces.Callback;
import com.sprout.interfaces.goods.IGood;
import com.sprout.mode.car.CarBean;
import com.sprout.mode.data.GoodDetailBean;
import com.sprout.mode.data.NewGoodsBean;
import com.sprout.net.CommonSubscriber;
import com.sprout.net.HttpManager;
import com.sprout.utils.RxUtils;

public class GoodDetailModel extends BaseModel implements IGood.Model {
    @Override
    public void getGoodDetail(int id, Callback<GoodDetailBean> callback) {
        addDisposable(HttpManager.getInstance().getService().getGoodDetail(id).
                compose(RxUtils.rxScheduler()).
                subscribeWith(new CommonSubscriber<GoodDetailBean>(callback){

                    @Override
                    public void onNext(GoodDetailBean goodDetailBean) {
                        callback.success(goodDetailBean);
                    }
                }));
    }

    @Override
    public void getCar(Callback<CarBean> callback) {
        addDisposable(HttpManager.getInstance().getService().getCarData().
                compose(RxUtils.rxScheduler()).
                subscribeWith(new CommonSubscriber<CarBean>(callback){

                    @Override
                    public void onNext(CarBean carBean) {
                        callback.success(carBean);
                    }
                }));
    }
}
