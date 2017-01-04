package com.sxwz.quick.app.mvp.listener;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/9 17:05
 * description: 加载数据监听
 *****************************************************/

public interface OnLoadDataListListener<T> {
    void onSuccess(T data);
    void onFailure(Throwable e);
}
