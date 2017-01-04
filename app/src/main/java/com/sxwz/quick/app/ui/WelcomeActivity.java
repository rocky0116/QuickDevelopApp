package com.sxwz.quick.app.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

import com.sxwz.qcodelib.base.ZActivity;
import com.sxwz.qcodelib.utils.PreferenceHelper;
import com.sxwz.quick.app.MainActivity;
import com.sxwz.quick.app.R;
import com.sxwz.quick.app.utils.UIHelper;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2017/1/3 17:39
 * description:
 *****************************************************/

public class WelcomeActivity extends ZActivity {
    @Bind(R.id.welcome_layout)
    LinearLayout welcome_layout;

    private static final int MESSAGE_INTENT = 1001;
    private static final long DELAY_TIME = 2000;

    private Timer timer = null;
    private Handler handler = null;
    @Override
    protected int getLayoutId() {
        isSideBack=false;
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {
        super.initData();
        showRandomWelcome();
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (msg.what == MESSAGE_INTENT) {
                    boolean isFirst=
                            PreferenceHelper.readBoolean(aty, UIHelper.PREFER_NAME,UIHelper.IS_FIRST_LOADING,false);
                    if (isFirst) {
                        $startActivity(MainActivity.class);
                        finish();
                    } else {
                        $startActivity(GuideActivity.class);
                        finish();
                    }
                }
            }
        };

        if (null == timer) {
            timer = new Timer();
        }

        timer.schedule(refreshTimerTask(), DELAY_TIME);
    }

    private TimerTask refreshTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (handler == null) {
                    return;
                }

                Message message = new Message();
                message.what = MESSAGE_INTENT;
                handler.sendMessage(message);
            }
        };
    }

    private void showRandomWelcome() {
        int[] welcome = new int[]{R.mipmap.welcome_page, R.mipmap.guide_1,
                R.mipmap.guide_2};
        Random r = new Random();
        int index = r.nextInt(3);
        welcome_layout.setBackgroundResource(welcome[index]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        handler = null;
    }
}
