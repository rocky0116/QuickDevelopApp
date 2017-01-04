package com.sxwz.quick.app.mvp.presenter;


import com.sxwz.quick.app.mvp.listener.OnLoadDataListListener;
import com.sxwz.quick.app.mvp.model.ListModel;
import com.sxwz.quick.app.mvp.view.ListDataView;

import java.util.List;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/9 17:12
 * description:
 *****************************************************/

public class ListPresent implements OnLoadDataListListener<List<?>> {

    private ListDataView mDataView;
    private ListModel mModel;

    private boolean isjz;

    public ListPresent(ListDataView mDataView){
        this.mDataView=mDataView;
        this.mModel=new ListModel();
    }

    public void LoadData(int PageIndex, int PageSize,boolean isjz,int requestType){
        this.isjz=isjz;
        mModel.LoadData(PageIndex,PageSize,this,requestType);
        if(!isjz){
            mDataView.showProgress();
        }
    }

    @Override
    public void onSuccess(List<?> data) {
        if(isjz){
            if(data.size()==0){
                mDataView.showLoadCompleteAllData();
            }else{
                //新增自动加载的的数据
                mDataView.addDatas(data);
            }
        }else{
            if(data.size()==0){
                mDataView.showNoData();
            }else{
                mDataView.newDatas(data);
            }
        }
        mDataView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mDataView.showLoadFailMsg();
    }
}
