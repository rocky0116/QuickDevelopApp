package com.sxwz.qcodelib.banner.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/26 15:53
 * description:
 *****************************************************/
public class ZoomFadePageTransformer extends BGAPageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);

        ViewCompat.setPivotX(view, view.getWidth() * 0.5f);
        ViewCompat.setPivotY(view, view.getHeight() * 0.5f);
        ViewCompat.setScaleX(view, 1 + position);
        ViewCompat.setScaleY(view, 1 + position);

        ViewCompat.setAlpha(view, 1 + position);
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);

        ViewCompat.setPivotX(view, view.getWidth() * 0.5f);
        ViewCompat.setPivotY(view, view.getHeight() * 0.5f);
        ViewCompat.setScaleX(view, 1 - position);
        ViewCompat.setScaleY(view, 1 - position);
        ViewCompat.setAlpha(view, 1 - position);
    }

}