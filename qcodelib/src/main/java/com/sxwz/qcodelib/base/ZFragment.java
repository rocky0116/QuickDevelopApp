
package com.sxwz.qcodelib.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxwz.qcodelib.R;
import com.sxwz.qcodelib.log.ZLog;
import com.sxwz.qcodelib.utils.ToastUtil;

import butterknife.ButterKnife;

import static com.sxwz.qcodelib.utils.ClipboardUtils.getIntent;


/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/29 12:14
 * description: fragment 基类，添加注解，toast，log，常用方法
 *****************************************************/
public abstract class ZFragment extends Fragment implements View.OnClickListener {


    /**
     * initialization widget, you should look like parentView.findviewbyid(id);
     * call method
     *
     * @param parentView 根View
     */
    protected void initWidget(View parentView) {
    }

    /**
     * initialization data
     */
    protected void initData() {
    }


    /**
     * widget click method
     * 用注解的，可以不用
     */
    protected void widgetClick(View v) {
    }

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }


    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
            ButterKnife.bind(this, rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        ButterKnife.bind(this, rootView);
        initWidget(rootView);
        initData();
        return rootView;
    }

    protected abstract int getLayoutResource();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * log日志
     *
     * @param msg
     */
    protected void $Log(String msg) {
        ZLog.d(this.getClass().getName(), msg);
    }


    /**
     * toast提示 自定义toast
     *
     * @param msg     提示信息
     * @param isRight 信息类型（true是正常提醒，false是错误提醒）
     */
    protected void $toast(String msg, boolean isRight) {
        ToastUtil.showToast(getActivity(), msg, isRight);
    }

    /**
     * 同上
     *
     * @param resId   提示信息string.xml
     * @param isRight 同上
     */
    protected void $toast(int resId, boolean isRight) {
        ToastUtil.showToast(getActivity(), resId, isRight);
    }

    /**
     * 跳转activity 无传参
     *
     * @param cls 跳转activity
     */
    protected void $startActivity(Class<?> cls) {
        $startActivity(cls, null);
    }

    /**
     * 跳转activity
     *
     * @param cls
     * @param bundle
     */
    protected void $startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * startActivityForResult跳转
     *
     * @param cls
     * @param requestCode 请求编码
     */
    protected void $startActivityForResult(Class<?> cls, int requestCode) {
        $startActivityForResult(cls, null, requestCode);
    }


    /**
     * @param cls
     * @param bundle
     * @param requestCode
     */
    protected void $startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * 获取bundle值
     *
     * @return bundle信息
     */
    protected Bundle $getIntentExtra() {
        Intent intent = getIntent();
        Bundle bundle = null;
        if (null != intent)
            bundle = intent.getExtras();
        return bundle;
    }
}
