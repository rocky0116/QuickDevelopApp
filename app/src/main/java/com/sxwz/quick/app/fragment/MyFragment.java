package com.sxwz.quick.app.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sxwz.qcodelib.base.ZFragment;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.ui.MyCodeActivity;
import com.sxwz.quick.app.ui.SettingActivity;

import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/30 11:25
 * description:
 *****************************************************/

public class MyFragment extends ZFragment {
    @Bind(R.id.txt_user_info)
    TextView txtUserInfo;
    @Bind(R.id.avatar_iv)
    ImageView avatar_iv;
    @Bind(R.id.txt_fav)
    TextView txtFav;
    @Bind(R.id.txt_card)
    TextView txtCard;
    @Bind(R.id.txt_setting)
    TextView txtSetting;
    private String content;
    private String tab;

    public MyFragment() {
        super();
    }


    public static MyFragment newInstance(String content, String tab) {
        MyFragment newFragment = new MyFragment();
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
        return R.layout.my_fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        Glide.with(getActivity())
                .load(R.mipmap.avatar)
                .animate(R.anim.zoom_in)
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有的图片
                .bitmapTransform(new CropCircleTransformation(getActivity()))
                .into(avatar_iv);
    }

    @OnClick({R.id.txt_user_info, R.id.txt_fav, R.id.txt_card, R.id.txt_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_user_info:
                $startActivity(MyCodeActivity.class);
                break;
            case R.id.txt_fav:
                break;
            case R.id.txt_card:
                break;
            case R.id.txt_setting:
                $startActivity(SettingActivity.class);
                break;
        }
    }
}
