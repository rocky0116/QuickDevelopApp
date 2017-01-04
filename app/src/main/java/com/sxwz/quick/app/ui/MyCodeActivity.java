package com.sxwz.quick.app.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.quick.app.R;

import butterknife.Bind;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/21 14:26
 * description:
 *****************************************************/

public class MyCodeActivity extends ZActivity {
    @Bind(R.id.back_iv)
    ImageView backIv;
    @Bind(R.id.txt_topbar)
    TextView txtTopbar;
    @Bind(R.id.head)
    ImageView head;
    @Bind(R.id.tvname)
    TextView tvname;
    @Bind(R.id.tvmsg)
    TextView tvmsg;
    @Bind(R.id.iv_sex)
    ImageView ivSex;
    @Bind(R.id.view_user)
    RelativeLayout viewUser;
    @Bind(R.id.img_code)
    ImageView imgCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mycode;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        txtTopbar.setText(R.string.txt_my);
        Glide.with(this)
                .load(R.mipmap.avatar)
                .bitmapTransform(new CropCircleTransformation(this))
                .dontAnimate()
                .into(head);
        Glide.with(this)
                .load(R.mipmap.my_code)
                .bitmapTransform(new CropCircleTransformation(this))
                .dontAnimate()
                .into(imgCode);
    }

    @Override
    public void widgetClick(View v) {

    }



    @OnClick(R.id.back_iv)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_iv:
                $finish();
                break;
        }
    }



}
