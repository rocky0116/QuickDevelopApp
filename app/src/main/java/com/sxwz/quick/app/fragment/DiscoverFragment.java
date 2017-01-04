package com.sxwz.quick.app.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sxwz.qcodelib.base.ZFragment;
import com.sxwz.quick.app.R;

import butterknife.Bind;
import butterknife.OnClick;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/30 11:25
 * description:
 *****************************************************/

public class DiscoverFragment extends ZFragment {
    @Bind(R.id.txt_pengyouquan)
    TextView txtPengyouquan;
    @Bind(R.id.txt_saoyisao)
    TextView txtSaoyisao;
    @Bind(R.id.txt_yaoyiyao)
    TextView txtYaoyiyao;
    @Bind(R.id.txt_nearby)
    TextView txtNearby;
    @Bind(R.id.txt_piaoliuping)
    TextView txtPiaoliuping;
    @Bind(R.id.txt_shop)
    TextView txtShop;
    @Bind(R.id.txt_game)
    TextView txtGame;
    private String content;
    private String tab;

    public DiscoverFragment() {
        super();
    }


    public static DiscoverFragment newInstance(String content, String tab) {
        DiscoverFragment newFragment = new DiscoverFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        bundle.putString("tab", tab);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            tab = args.getString("tab");
            content = args.getString("content");
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.discover_fragment;
    }


    @OnClick({R.id.txt_pengyouquan, R.id.txt_saoyisao, R.id.txt_yaoyiyao,
            R.id.txt_nearby, R.id.txt_piaoliuping, R.id.txt_shop, R.id.txt_game})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_pengyouquan:
                break;
            case R.id.txt_saoyisao:
                break;
            case R.id.txt_yaoyiyao:
                break;
            case R.id.txt_nearby:
                break;
            case R.id.txt_piaoliuping:
                break;
            case R.id.txt_shop:
                break;
            case R.id.txt_game:
                break;
        }
    }
}
