package com.sxwz.qcodelib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sxwz.qcodelib.R;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/26 16:18
 * description: 自定义Toast
 *****************************************************/
public class ToastUtil {

	private static View view = null;
	private static TextView tvMessage = null;
	private static ImageView ivTip = null;

	public static void showToast(Context context, String msg, boolean isRight) {
		if (TextUtils.isEmpty(msg)) {
			return;
		}

		try {
			initView(context);

			tvMessage.setText(msg);
			if (isRight) {
				ivTip.setBackgroundResource(R.drawable.toast_tip_right);
			} else {
				ivTip.setBackgroundResource(R.drawable.toast_tip_wrong);
			}

			Toast toast = new Toast(context);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(view);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showToast(Context context, int resId, boolean isRight) {
		String msg=context.getResources().getString(resId);
		if (TextUtils.isEmpty(msg)) {
			return;
		}

		try {
			initView(context);

			tvMessage.setText(msg);
			if (isRight) {
				ivTip.setBackgroundResource(R.drawable.toast_tip_right);
			} else {
				ivTip.setBackgroundResource(R.drawable.toast_tip_wrong);
			}

			Toast toast = new Toast(context);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(view);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initView(Context context) {
		if (view != null) {
			return;
		}

		view = LayoutInflater.from(context).inflate(R.layout.toast,
				null);

		tvMessage = (TextView) view.findViewById(R.id.tvMessage);
		ivTip = (ImageView) view.findViewById(R.id.ivTip);
	}
}
