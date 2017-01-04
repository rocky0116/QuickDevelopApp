package com.sxwz.qcodelib.base;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/19 16:41
 * description: 万能Adapter
 *****************************************************/

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sxwz.qcodelib.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class AdapterHolder {
    private final SparseArray<View> mViews;
    private final int mPosition;
    private final View mConvertView;

    private AdapterHolder(ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(parent.getContext()).inflate(
                layoutId, parent, false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到全部View
     * 
     * @return
     */
    public SparseArray<View> getAllView() {
        return mViews;
    }

    /**
     * 拿到一个ViewHolder对象
     * 
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static AdapterHolder get(View convertView, ViewGroup parent,
            int layoutId, int position) {
        if (convertView == null) {
            return new AdapterHolder(parent, layoutId, position);
        } else {
            return (AdapterHolder) convertView.getTag();
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     * 
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     * 
     * @param viewId
     * @param text
     * @return
     */
    public AdapterHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     * 
     * @param viewId
     * @param drawableId
     * @return
     */
    public AdapterHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     * 
     * @param viewId
     * @param bm
     * @return
     */
    public AdapterHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置网络图片
     * @param context
     * @param viewId
     * @param url
     * @param defaultDrawable  默认图片
     * @param isCircle 是否是圆形
     * @return
     */
    public AdapterHolder setImageByUrl(Context context,
                                       int viewId,
                                       String url,
                                       int defaultDrawable,
                                       boolean isCircle) {
        ImageView view = getView(viewId);
        if (isCircle) {
            Glide.with(context)
                    .load(url)
                    .animate(R.anim.zoom_in)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有的图片
                    .bitmapTransform(new CropCircleTransformation(context))
                    .placeholder(defaultDrawable)
                    .dontAnimate()
                    .into(view);
        }else {
            Glide.with(context)
                    .load(url)
                    .animate(R.anim.zoom_in)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有的图片
                    .placeholder(defaultDrawable)    //占位符 也就是加载中的图片，可放个gif
                    .fitCenter()
                    .into(view);
        }
        return this;
    }

    public int getPosition() {
        return mPosition;
    }

}
