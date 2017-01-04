package com.sxwz.qcodelib.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.sxwz.qcodelib.R;
import com.sxwz.qcodelib.log.ZLog;
import com.sxwz.qcodelib.sback.BackActivityHelper;
import com.sxwz.qcodelib.sback.SUtils;
import com.sxwz.qcodelib.sback.SwipeBackLayout;
import com.sxwz.qcodelib.utils.AppManager;
import com.sxwz.qcodelib.utils.ToastUtil;

import butterknife.ButterKnife;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/29 12:14
 * description: activity 基类，添加注解，toast，log，常用方法
 *****************************************************/

public abstract class ZActivity extends AppCompatActivity implements View.OnClickListener {

    protected boolean isDebug = true;
    public Activity aty;
    private BackActivityHelper mHelper;
    protected boolean isSideBack = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aty = this;
        setContentView(getLayoutId());
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        //侧滑返回
        initSwipBack();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
//                    localLayoutParams.flags);
//        }

        ButterKnife.bind(this);    //注解，可以不使用，也可以启用其他
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);

        initView();

        setListener();
        initData();
        registerBroadcast();
    }

    protected void initSwipBack() {
        mHelper = new BackActivityHelper(this);
        if (isSideBack) {
            mHelper.onActivityCreate();
        }
    }


    /**
     * 通用title
     */
    protected void $setToolBar() {
//        Toolbar toolbar = $findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    /**
     * log日志
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            ZLog.d(this.getClass().getName(), msg);
        }
    }


    /**
     * toast提示 自定义toast
     *
     * @param msg     提示信息
     * @param isRight 信息类型（true是正常提醒，false是错误提醒）
     */
    protected void $toast(String msg, boolean isRight) {
        ToastUtil.showToast(this, msg, isRight);
    }

    /**
     * 同上
     *
     * @param resId   提示信息string.xml
     * @param isRight 同上
     */
    protected void $toast(int resId, boolean isRight) {
        ToastUtil.showToast(this, resId, isRight);
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
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
     * 关闭activity
     */
    protected void $finish() {
        finish();
        overridePendingTransition(R.anim.no_move, R.anim.right_out);
    }

    /**
     * @param cls
     * @param bundle
     * @param requestCode
     */
    protected void $startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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

    /**
     * 简化findviewbyid
     * 此处用不到，此基类已使用ButterKnife注解
     * 在不使用注解的时候可以使用
     *
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T $findViewById(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 设置ContentView
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected void initView() {

    }

    /**
     * add Listener
     */
    protected void setListener() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }


    protected void registerBroadcast() {
    }

    protected void unRegisterBroadcast() {
    }

    /**
     * view点击
     *
     * @param v
     */
    public void widgetClick(View v) {

    }

    private long lastClick = 0;

    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }


    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null) {
            v = mHelper.findViewById(id);
        }
        return v;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setSwipeBackEnable(enable);
    }

    public void scrollToFinishActivity() {
        SUtils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        aty = null;
        unRegisterBroadcast();
    }
}
