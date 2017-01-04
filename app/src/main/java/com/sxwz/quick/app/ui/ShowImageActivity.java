package com.sxwz.quick.app.ui;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.utils.UIHelper;

import butterknife.Bind;
import butterknife.OnClick;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2017/1/4 17:03
 * description:
 *****************************************************/

public class ShowImageActivity extends ZActivity {
    @Bind(R.id.show_image)
    ImageView showImage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_image;
    }

    @Override
    protected void initData() {
        super.initData();
        String image_url=$getIntentExtra().getString(UIHelper.WEB_URL);
        Glide.with(this)
                .load(image_url)
                .error(R.mipmap.holder)
                .dontAnimate()
                .centerCrop()
                .into(showImage);
    }

    @OnClick(R.id.show_image)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_image:
                $finish();
                break;
        }
    }
}
