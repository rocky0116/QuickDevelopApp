package com.sxwz.quick.app.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sxwz.qcodelib.base.BasePullUpRecyclerAdapter;
import com.sxwz.qcodelib.base.ZFragment;
import com.sxwz.qcodelib.container.DefaultHeader;
import com.sxwz.qcodelib.widget.ProgressDialog;
import com.sxwz.qcodelib.widget.RefreshView;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.adapter.ServiceAdapter;
import com.sxwz.quick.app.entity.AllListEntity;
import com.sxwz.quick.app.mvp.presenter.ListPresent;
import com.sxwz.quick.app.mvp.view.ListDataView;
import com.sxwz.quick.app.ui.PublicActivity;
import com.sxwz.quick.app.utils.UIHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/30 11:25
 * description:
 *****************************************************/

public class ServiceFragment extends ZFragment
        implements ListDataView, RefreshView.OnFreshListener,
        BasePullUpRecyclerAdapter.OnPullUpListener,
        BasePullUpRecyclerAdapter.OnItemClickListener {

    @Bind(R.id.rv_list)
    RecyclerView rvList;
    @Bind(R.id.refresh_view)
    RefreshView refreshView;

    private ProgressDialog dialog;

    private int pageIndex = 1;
    private ListPresent present;
    private ServiceAdapter mAdapter;
    private List<AllListEntity.ResultsBean> listData = new ArrayList<AllListEntity.ResultsBean>();

    private String content;
    private String tab;

    public ServiceFragment() {
        super();
    }


    public static ServiceFragment newInstance(String content, String tab) {
        ServiceFragment newFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        bundle.putString("tab", tab);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            tab = args.getString("tab");
            content = args.getString("content");
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.service_fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        //设置页面为加载中..
        dialog = ProgressDialog.createDialog(getActivity());
        dialog.setMessage(getString(R.string.txt_loading));

        present = new ListPresent(this);
        //设置下拉刷新监听
        refreshView.setListener(this);
        //设置下拉刷新样式
        refreshView.setType(RefreshView.Type.FOLLOW);
        refreshView.setHeader(new DefaultHeader(getActivity()));
        //springView.setFooter(new RotationFooter(this));mRecyclerView内部集成的自动加载  上啦加载用不上   在其他View使用
        //设置RecyclerView的显示模式  当前List模式
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //如果Item高度固定  增加该属性能够提高效率
        rvList.setHasFixedSize(true);

        //设置适配器
        mAdapter = new ServiceAdapter(rvList, listData, R.layout.list_view_item_layout);
        //设置加载动画 === 待完善
//        mAdapter.openLoadAnimation(ZRecyclerAdapter.SCALEIN);
        //将适配器添加到RecyclerView
        rvList.setAdapter(mAdapter);
        mAdapter.setPullUpListener(this);
        mAdapter.setOnItemClickListener(this);
        //请求网络数据
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, false, UIHelper.HOME_REQUEST_TYPE);
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.cancel();
    }

    @Override
    public void newDatas(List<?> newsList) {
        dialog.cancel();
        listData.addAll((Collection<? extends AllListEntity.ResultsBean>) newsList);
        mAdapter.notifyDataSetChanged();
        refreshView.onFinishFreshAndLoad();//刷新完成
    }

    @Override
    public void addDatas(List<?> addList) {
        listData.addAll((Collection<? extends AllListEntity.ResultsBean>) addList);
        mAdapter.notifyDataSetChanged();
        refreshView.onFinishFreshAndLoad();//刷新完成
    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void showLoadCompleteAllData() {

    }

    @Override
    public void showNoData() {

    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        listData.clear();
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, false, UIHelper.HOME_REQUEST_TYPE);
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onBottom(int state) {
        $Log("===" + state);
        mAdapter.setState(BasePullUpRecyclerAdapter.STATE_LOADING);
        ++pageIndex;
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, true, UIHelper.HOME_REQUEST_TYPE);
    }

    @Override
    public void onItemClick(View view, Object data, int position) {
        AllListEntity.ResultsBean item= (AllListEntity.ResultsBean) data;
        Bundle bundle = new Bundle();
        bundle.putString(UIHelper.WEB_TITLE, item.getDesc());
        bundle.putString(UIHelper.WEB_URL, item.getUrl());
        $startActivity(PublicActivity.class, bundle);

    }
}
