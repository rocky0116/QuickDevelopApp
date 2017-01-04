package com.sxwz.qcodelib.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/11/19 16:41
 * description:
 *****************************************************/
public class SlideInRightAnimation implements BaseAnimation {


    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationX", view.getRootView().getWidth(), 0)
        };
    }
}
