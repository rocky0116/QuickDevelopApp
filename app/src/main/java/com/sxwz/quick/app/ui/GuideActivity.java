package com.sxwz.quick.app.ui;

import android.widget.Button;
import android.widget.TextView;

import com.sxwz.qcodelib.banner.BGABanner;
import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.qcodelib.utils.PreferenceHelper;
import com.sxwz.quick.app.MainActivity;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.utils.UIHelper;

import butterknife.Bind;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2017/1/4 11:19
 * description:
 *****************************************************/

public class GuideActivity extends ZActivity {
    @Bind(R.id.banner_guide_background)
    BGABanner bannerGuideBackground;
    @Bind(R.id.banner_guide_foreground)
    BGABanner bannerGuideForeground;
    @Bind(R.id.tv_guide_skip)
    TextView tvGuideSkip;
    @Bind(R.id.btn_guide_enter)
    Button btnGuideEnter;

    @Override
    protected int getLayoutId() {
        isSideBack = false;
        return R.layout.activity_guide;
    }


    @Override
    protected void initData() {
        super.initData();
        // 设置数据源
        bannerGuideBackground.setData(R.mipmap.guide_1,
                R.mipmap.guide_2,
                R.mipmap.guide_3);

        bannerGuideForeground.setData(R.mipmap.uoko_guide_foreground_1,
                R.mipmap.uoko_guide_foreground_2,
                R.mipmap.uoko_guide_foreground_3);

        PreferenceHelper.write(this, UIHelper.PREFER_NAME,UIHelper.IS_FIRST_LOADING,true);

    }

    @Override
    protected void setListener() {
        super.setListener();
        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        bannerGuideForeground.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                $startActivity(MainActivity.class);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        bannerGuideBackground.setBackgroundResource(android.R.color.white);
    }
}
