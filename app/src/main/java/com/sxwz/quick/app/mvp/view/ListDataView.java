package com.sxwz.quick.app.mvp.view;

import java.util.List;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/9 17:07
 * description:
 *****************************************************/

public interface ListDataView {
    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(List<?> newsList);
    //添加更多数据
    void addDatas(List<?> addList);
    //显示加载失败
    void showLoadFailMsg();
    //显示已加载所有数据
    void showLoadCompleteAllData();
    //显示无数据
    void showNoData();
}
