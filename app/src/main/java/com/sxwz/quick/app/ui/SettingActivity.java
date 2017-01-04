package com.sxwz.quick.app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.utils.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sxwz.quick.app.R.id.txt_topbar;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/21 14:27
 * description:
 *****************************************************/

public class SettingActivity extends ZActivity {

    @Bind(txt_topbar)
    TextView txtTopbar;
    @Bind(R.id.txt_usersafe)
    TextView txtUsersafe;
    @Bind(R.id.txt_msgtip)
    TextView txtMsgtip;
    @Bind(R.id.txt_yinsi)
    TextView txtYinsi;
    @Bind(R.id.txt_tongyong)
    TextView txtTongyong;
    @Bind(R.id.txt_about)
    TextView txtAbout;
    @Bind(R.id.btnexit)
    Button btnexit;
    @Bind(R.id.back_iv)
    ImageView back_iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        txtTopbar.setText(R.string.txt_setting);
    }

    @Override
    public void widgetClick(View v) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.txt_usersafe, R.id.txt_msgtip, R.id.txt_yinsi,
            R.id.txt_tongyong, R.id.txt_about, R.id.btnexit,
            R.id.back_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_usersafe:
                goPublicPage(getString(R.string.github_page));
                break;
            case R.id.txt_msgtip:
                goPublicPage(getString(R.string.github_page));
                break;
            case R.id.txt_yinsi:
                goPublicPage(getString(R.string.personal_home_page));
                break;
            case R.id.txt_tongyong:
                goPublicPage(getString(R.string.personal_home_page));
                break;
            case R.id.txt_about:
                goPublicPage(getString(R.string.personal_home_page));
                break;
            case R.id.btnexit:
                break;
            case R.id.back_iv:
                $finish();
                break;
        }
    }

    private void goPublicPage(String web_url){
        Bundle bundle = new Bundle();
        bundle.putString(UIHelper.WEB_TITLE, getString(R.string.personal_description));
        bundle.putString(UIHelper.WEB_URL, web_url);
        $startActivity(PublicActivity.class, bundle);
    }
}
