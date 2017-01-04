package com.sxwz.quick.app.mvp.model;

import android.util.Log;

import com.sxwz.quick.app.entity.AllListEntity;
import com.sxwz.quick.app.entity.PrettyPicEntity;
import com.sxwz.quick.app.http.RequestHttpData;
import com.sxwz.quick.app.mvp.listener.OnLoadDataListListener;
import com.sxwz.quick.app.utils.UIHelper;


import rx.Subscriber;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/9 17:14
 * description:
 *****************************************************/

public class ListModel {
    private Subscriber subscriber;
    public void LoadData(int PageIndex,
                         int PageSize,
                         final OnLoadDataListListener listener,
                         int requestType) {

        switch (requestType) {

            case UIHelper.HOME_REQUEST_TYPE:

                subscriber = new Subscriber<AllListEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TG","=====completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TG","====="+e.getMessage());
                        listener.onFailure(e);
                    }

                    @Override
                    public void onNext(AllListEntity movieEntity) {
                        Log.d("TG","====="+movieEntity.toString());
                        Log.d("TG","====="+movieEntity.getResults().size());
                        listener.onSuccess(movieEntity.getResults());
                    }
                };
                RequestHttpData.getInstance().getAllList(subscriber, PageSize, PageIndex);

                break;
            case UIHelper.PRETTY_PIC_REQUEST_TYPE:
                subscriber = new Subscriber<PrettyPicEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TG","=====completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TG","====="+e.getMessage());
                        listener.onFailure(e);
                    }

                    @Override
                    public void onNext(PrettyPicEntity prettyPicEntity) {
                        Log.d("TG","====="+prettyPicEntity.toString());
                        listener.onSuccess(prettyPicEntity.getResults());
                    }
                };
                RequestHttpData.getInstance().getPrettyPic(subscriber, PageSize, PageIndex);
                break;

        }

    }

}
