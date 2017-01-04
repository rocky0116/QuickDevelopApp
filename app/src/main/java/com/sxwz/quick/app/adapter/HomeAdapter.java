package com.sxwz.quick.app.adapter;

import android.support.v7.widget.RecyclerView;

import com.sxwz.qcodelib.base.BasePullUpRecyclerAdapter;
import com.sxwz.qcodelib.base.RecyclerHolder;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.entity.AllListEntity;
import com.sxwz.quick.app.entity.PrettyPicEntity;

import java.util.Collection;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/30 15:29
 * description:
 *****************************************************/

public class HomeAdapter extends BasePullUpRecyclerAdapter<PrettyPicEntity.ResultsBean> {
    public HomeAdapter(RecyclerView v, Collection<PrettyPicEntity.ResultsBean> datas,
                       int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, PrettyPicEntity.ResultsBean item, int position) {
        holder.setImageByUrl(cxt,R.id.listview_image_url,
                item.getUrl(),
                R.mipmap.avatar,false);
    }
}
