package com.sxwz.qcodelib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import java.util.List;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/26 16:02
 * description: Activity 工具类
 *****************************************************/

public class ActivityUtils {
    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 判断是否存在Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   activity全路径类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isActivityExists(Context context, String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return !(context.getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(context.getPackageManager()) == null ||
                context.getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * 打开Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   全类名
     */
    public static void launchActivity(Context context, String packageName, String className) {
        launchActivity(context, packageName, className, null);
    }

    /**
     * 打开Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   全类名
     * @param bundle      bundle
     */
    public static void launchActivity(Context context, String packageName, String className, Bundle bundle) {
        context.startActivity(IntentUtils.getComponentIntent(packageName, className, bundle));
    }

    /**
     * 获取launcher activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @return launcher activity
     */
    public static String getLauncherActivity(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "no " + packageName;
    }


    /**
     * activity跳转
     *
     * @param context 上下文
     * @param cls     跳转对象
     * @param bundle  使用bundle传值（不为空，则有传递数据，否则，不用传值）
     */
    public static void jumpToActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent jumpIntent = new Intent();
        if (bundle != null)
            jumpIntent.putExtras(bundle);
        jumpIntent.setClass(context, cls);
        context.startActivity(jumpIntent);
    }

    /**
     * 跳转activity使用result
     *
     * @param context     同上
     * @param cls         跳转类
     * @param bundle      传值 （同上）
     * @param requestCode 请求编码
     */
    public static void jumpToResActivity(Context context, Class<?> cls, Bundle bundle, int requestCode) {
        Intent jumpIntent = new Intent();
        if (bundle != null)
            jumpIntent.putExtras(bundle);
        jumpIntent.setClass(context, cls);
        ((Activity) context).startActivityForResult(jumpIntent, requestCode);
    }

    /**
     * 关闭activity，返回需要的result
     *
     * @param context    同上
     * @param intent     intent数据结果
     * @param resutlCode 结果编码
     */
    public static void toFinishResult(Context context, Intent intent, int resutlCode) {
        ((Activity) context).setResult(resutlCode, intent);
        ((Activity) context).finish();
    }

}
