package com.sxwz.quick.app.ui;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.utils.UIHelper;

import java.lang.reflect.InvocationTargetException;

import butterknife.Bind;
import butterknife.OnClick;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/21 14:46
 * description:
 *****************************************************/

public class PublicActivity extends ZActivity {
    @Bind(R.id.back_iv)
    ImageView back_iv;
    @Bind(R.id.txt_topbar)
    TextView title;
    @Bind(R.id.mwebview)
    WebView mWebView;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    private String strurl = "";
    private MyTimer mTimer;
    private int progress = 0;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            mWebView.getClass().getMethod("onResume")
                    .invoke(mWebView, (Object[]) null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            mWebView.getClass().getMethod("onPause")
                    .invoke(mWebView, (Object[]) null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    protected void initData(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString(UIHelper.WEB_URL) != null) {
            strurl = "";
            strurl = bundle.getString(UIHelper.WEB_URL);
        }
        if (bundle != null && bundle.getString(UIHelper.WEB_TITLE) != null) {
            title.setText(bundle.getString(UIHelper.WEB_TITLE));
        }
        if (!TextUtils.isEmpty(strurl)) {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WeiboWebViewClient());
            mWebView.setWebChromeClient(new WebChromeClient());

            if (Build.VERSION.SDK_INT >= 19) {
                mWebView.getSettings().setLoadsImagesAutomatically(true);
            } else {
                mWebView.getSettings().setLoadsImagesAutomatically(false);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }

            mWebView.loadUrl(strurl);
        }
    }

    @Override
    public void widgetClick(View v) {

    }


    @OnClick({R.id.back_iv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                if (mWebView.canGoBack())
                    mWebView.goBack();
                else
                    $finish();
                break;
        }
    }

    private class WeiboWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            // TODO 显示错误404
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (mTimer == null) {
                mTimer = new MyTimer(15000, 50);
            }
            mTimer.start();
            if (progressbar!=null)
                progressbar.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressbar==null){
                return;
            }
            if (!mWebView.getSettings().getLoadsImagesAutomatically()) {
                mWebView.getSettings().setLoadsImagesAutomatically(true);
            }
            mTimer.cancel();

            progress = 0;
            if (progressbar!=null) {
                progressbar.setProgress(100);
                progressbar.setVisibility(View.GONE);
            }
        }
    }

    /* 定义一个倒计时的内部类 */
    private class MyTimer extends CountDownTimer {
        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            progress = 100;
            if (progressbar!=null)
            progressbar.setVisibility(View.GONE);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (progressbar!=null) {
                if (progress == 100) {
                    progressbar.setVisibility(View.GONE);
                } else {
                    progressbar.setProgress(progress++);
                }
            }
        }
    }
}
