package com.sxwz.quick.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.quick.app.fragment.DiscoverFragment;
import com.sxwz.quick.app.fragment.HomeFragment;
import com.sxwz.quick.app.fragment.MyFragment;
import com.sxwz.quick.app.fragment.ServiceFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends ZActivity {
    @Bind(R.id.txt_topbar)
    TextView txtTopbar;
    @Bind(R.id.ly_top_bar)
    RelativeLayout lyTopBar;
    @Bind(R.id.txt_home)
    TextView txtHome;
    @Bind(R.id.txt_service)
    TextView txtService;
    @Bind(R.id.txt_discover)
    TextView txtDiscover;
    @Bind(R.id.txt_my)
    TextView txtMy;
    @Bind(R.id.ly_tab_bar)
    LinearLayout lyTabBar;
    @Bind(R.id.ly_content)
    FrameLayout lyContent;


    //中央可切换视图
    private HomeFragment homeFragment;
    private ServiceFragment serviceFragment;
    private DiscoverFragment discoverFragment;
    private MyFragment myFragment;
    private FragmentManager fManager;

    private FragmentTransaction fTransaction;

    @Override
    protected int getLayoutId() {
        isSideBack=false;
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fManager = getFragmentManager();
        txtHome.performClick();
    }


    //重置所有文本的选中状态
    private void setSelected() {
        txtHome.setSelected(false);
        txtService.setSelected(false);
        txtDiscover.setSelected(false);
        txtMy.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) fragmentTransaction.hide(homeFragment);
        if (serviceFragment != null) fragmentTransaction.hide(serviceFragment);
        if (discoverFragment != null) fragmentTransaction.hide(discoverFragment);
        if (myFragment != null) fragmentTransaction.hide(myFragment);
    }


    @OnClick({R.id.txt_home, R.id.txt_service, R.id.txt_discover, R.id.txt_my})
    public void onClick(View view) {
        fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()) {
            case R.id.txt_home:
                setSelected();
                txtHome.setSelected(true);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment().newInstance(getResources().getString(R.string.txt_home), "home");
                    fTransaction.add(R.id.ly_content, homeFragment);
                } else {
                    fTransaction.show(homeFragment);
                }
                txtTopbar.setText(R.string.txt_home);
                break;
            case R.id.txt_service:
                setSelected();
                txtService.setSelected(true);
                if (serviceFragment == null) {
                    serviceFragment = new ServiceFragment().newInstance(getResources().getString(R.string.txt_service), "service");
                    fTransaction.add(R.id.ly_content, serviceFragment);
                } else {
                    fTransaction.show(serviceFragment);
                }
                txtTopbar.setText(R.string.txt_service);
                break;
            case R.id.txt_discover:
                setSelected();
                txtDiscover.setSelected(true);
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment().newInstance(getResources().getString(R.string.txt_discover), "discover");
                    fTransaction.add(R.id.ly_content, discoverFragment);
                } else {
                    fTransaction.show(discoverFragment);
                }
                txtTopbar.setText(R.string.txt_discover);
                break;
            case R.id.txt_my:
                setSelected();
                txtMy.setSelected(true);
                if (myFragment == null) {
                    myFragment = new MyFragment().newInstance(getResources().getString(R.string.txt_my), "my");
                    fTransaction.add(R.id.ly_content, myFragment);
                } else {
                    fTransaction.show(myFragment);
                }
                txtTopbar.setText(R.string.txt_my);
                break;
        }
        fTransaction.commit();
    }
}
