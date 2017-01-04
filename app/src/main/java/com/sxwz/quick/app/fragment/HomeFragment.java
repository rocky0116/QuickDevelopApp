package com.sxwz.quick.app.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sxwz.qcodelib.banner.BGABanner;
import com.sxwz.qcodelib.base.BasePullUpRecyclerAdapter;
import com.sxwz.qcodelib.base.ZFragment;
import com.sxwz.qcodelib.container.DefaultHeader;
import com.sxwz.qcodelib.widget.ProgressDialog;
import com.sxwz.qcodelib.widget.RefreshView;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.adapter.HomeAdapter;
import com.sxwz.quick.app.entity.BannerModel;
import com.sxwz.quick.app.entity.PrettyPicEntity;
import com.sxwz.quick.app.mvp.presenter.ListPresent;
import com.sxwz.quick.app.mvp.view.ListDataView;
import com.sxwz.quick.app.ui.PublicActivity;
import com.sxwz.quick.app.ui.ShowImageActivity;
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

public class HomeFragment extends ZFragment
        implements BGABanner.Adapter<ImageView, String> ,
        BGABanner.Delegate<ImageView, String>,
        ListDataView,RefreshView.OnFreshListener,
        BasePullUpRecyclerAdapter.OnPullUpListener,
        BasePullUpRecyclerAdapter.OnItemClickListener{

    @Bind(R.id.banner_main_rotate)
    BGABanner bannerMainRotate;
    @Bind(R.id.rv_list)
    RecyclerView rvList;
    @Bind(R.id.refresh_view)
    RefreshView refreshView;

    private ProgressDialog dialog;
    private HomeAdapter mAdapter;
    private int pageIndex = 1;
    private ListPresent present;
    private List<PrettyPicEntity.ResultsBean> listData=new ArrayList<PrettyPicEntity.ResultsBean>();

    private String content;
    private String tab;

    public HomeFragment() {
        super();
    }


    public static HomeFragment newInstance(String content, String tab) {
        HomeFragment newFragment = new HomeFragment();
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
        return R.layout.home_fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        BannerModel bannerModel = new BannerModel();
        bannerModel.imgs.add("http://ww3.sinaimg.cn/large/610dc034gw1fb558z2peqj20u00u00v9.jpg");
        bannerModel.imgs.add("http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg");
        bannerModel.imgs.add("http://ww1.sinaimg.cn/large/610dc034gw1fb0kieivhgj20u00k2gmr.jpg");
        bannerModel.imgs.add("http://ww2.sinaimg.cn/large/610dc034jw1faza3ghd2lj20f00k1gof.jpg");
        bannerModel.imgs.add("http://ww3.sinaimg.cn/large/610dc034gw1fay98gt0ocj20u011hn24.jpg");

        bannerModel.tips.add(UIHelper.tips[0]);
        bannerModel.tips.add(UIHelper.tips[1]);
        bannerModel.tips.add(UIHelper.tips[2]);
        bannerModel.tips.add(UIHelper.tips[3]);
        bannerModel.tips.add(UIHelper.tips[4]);

        /**
         * 设置是否开启自动轮播，需要在 setData 方法之前调用，并且调了该方法后必须再调用一次 setData 方法
         * 例如根据图片当图片数量大于 1 时开启自动轮播，等于 1 时不开启自动轮播
         */
//                bannerMainRotate.setAutoPlayAble(bannerModel.imgs.size() > 1);

        bannerMainRotate.setAdapter(this);
        bannerMainRotate.setData(bannerModel.imgs, bannerModel.tips);

        bannerMainRotate.setDelegate(this);


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
        //在此处有一个抗，大家也看到了为什么设置这么多，在设置瀑布流的过程中
        //上下滑动之后，item的位置会发生变化，解决这个问题办法如下
        final StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rvList.setLayoutManager(layoutManager);
        //如果Item高度固定  增加该属性能够提高效率
        rvList.setHasFixedSize(true);

        //设置适配器
        mAdapter = new HomeAdapter(rvList,listData,R.layout.home_item_layout);
        //设置加载动画 === 待完善
//        mAdapter.openLoadAnimation(ZRecyclerAdapter.SCALEIN);
        //将适配器添加到RecyclerView
        rvList.setAdapter(mAdapter);
        mAdapter.setPullUpListener(this);
        mAdapter.setOnItemClickListener(this);
        //请求网络数据
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, false, UIHelper.PRETTY_PIC_REQUEST_TYPE);

        rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //此处是为了解决瀑布流第一行上面的空白格
                layoutManager.invalidateSpanAssignments();
            }
        });
    }


    @Override
    public void fillBannerItem(BGABanner banner,
                               ImageView itemView,
                               String model,
                               int position) {
        Glide.with(itemView.getContext())
                .load(model)
                .placeholder(R.mipmap.holder)
                .error(R.mipmap.holder)
                .dontAnimate()
                .centerCrop()
                .into(itemView);
    }

    @Override
    public void onBannerItemClick(BGABanner banner,
                                  ImageView itemView,
                                  String model, int position) {
        $toast("点击了="+position,true);
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
        listData.addAll((Collection<? extends PrettyPicEntity.ResultsBean>) newsList);
        mAdapter.notifyDataSetChanged();
        refreshView.onFinishFreshAndLoad();//刷新完成
    }

    @Override
    public void addDatas(List<?> addList) {
        listData.addAll((Collection<? extends PrettyPicEntity.ResultsBean>) addList);
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
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, false, UIHelper.PRETTY_PIC_REQUEST_TYPE);
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onBottom(int state) {
        $Log("==="+state);
        mAdapter.setState(BasePullUpRecyclerAdapter.STATE_LOADING);
        ++pageIndex;
        present.LoadData(pageIndex, UIHelper.DEFAULT_PAGE_SIZE, true, UIHelper.PRETTY_PIC_REQUEST_TYPE);
    }

    @Override
    public void onItemClick(View view, Object data, int position) {
        PrettyPicEntity.ResultsBean item= (PrettyPicEntity.ResultsBean) data;
        Bundle bundle = new Bundle();
        bundle.putString(UIHelper.WEB_TITLE, item.getDesc());
        bundle.putString(UIHelper.WEB_URL, item.getUrl());
        $startActivity(ShowImageActivity.class, bundle);
    }
}
