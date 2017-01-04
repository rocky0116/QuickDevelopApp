package com.sxwz.quick.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sxwz.qcodelib.base.BasePullUpRecyclerAdapter;
import com.sxwz.qcodelib.base.RecyclerHolder;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.entity.AllListEntity;

import java.util.Collection;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/30 15:29
 * description:
 *****************************************************/

public class ServiceAdapter extends BasePullUpRecyclerAdapter<AllListEntity.ResultsBean> {
    public ServiceAdapter(RecyclerView v, Collection<AllListEntity.ResultsBean> datas,
                          int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, AllListEntity.ResultsBean item, int position) {
        holder.setText(R.id.listview_tv_title,
                item.getDesc()).setText(R.id.listview_tv_content,
                "who:"+item.getWho());
        holder.setImageByUrl(cxt,R.id.listview_image_url,
                "http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg",
                R.mipmap.avatar,true);
    }
}
