package io.haydar.supercircle.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * File: DeorViewBitmapUtils.java
 * Author: ejiang
 * 屏幕裁剪
 * 1.全屏裁剪
 * 2.区域裁剪
 * Create: 2017-08-05 17:31
 */

public class DeorViewBitmapUtils {
    private static DeorViewBitmapUtils deorViewBitmapUtils;

    private DeorViewBitmapUtils() {
    }

    public synchronized static DeorViewBitmapUtils getInstence() {
        if (deorViewBitmapUtils == null) {
            deorViewBitmapUtils = new DeorViewBitmapUtils();
        }
        return deorViewBitmapUtils;
    }

    /**
     * 全屏截取
     *
     * @param activity
     * @return
     */
    private Bitmap deorWindowViewBitmap(Activity activity) {
        if (activity == null) throw new NullPointerException("activity对象为空~");
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        //获取整张图片
        Bitmap bitmap = decorView.getDrawingCache();
        // 获取状态栏高度
        Rect frame = new Rect();
        // 测量屏幕宽和高
        decorView.getWindowVisibleDisplayFrame(frame);
        int stautsHeight = frame.top;
        Log.d("jiangqq", "状态栏的高度为:" + stautsHeight);
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        // 根据坐标点和需要的宽和高创建bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, stautsHeight, width, height - stautsHeight);
        return bitmap;
    }

    private Bitmap deorWindowChildViewBitmap(Activity activity, View view) {
        if (activity == null || view == null) throw new NullPointerException("参数有误！");
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        //获取整张图片
        Bitmap bitmap = decorView.getDrawingCache();
        // 获取状态栏高度
        Rect frame = new Rect();
        // 测量屏幕宽和高
        decorView.getWindowVisibleDisplayFrame(frame);
        int stautsHeight = frame.top;
        Log.d("jiangqq", "状态栏的高度为:" + stautsHeight);
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        // 根据坐标点和需要的宽和高创建bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, stautsHeight, width, height - stautsHeight);
        if (bitmap != null) {
            int childWidth = view.getWidth();
            int childHeight = view.getHeight();
            //获取需要截图部分的在屏幕上的坐标(view的左上角坐标）
            int[] viewLocationArray = new int[2];
            view.getLocationOnScreen(viewLocationArray);
            //从屏幕整张图片中截取指定区域
            bitmap = Bitmap.createBitmap(bitmap, viewLocationArray[0], viewLocationArray[1], childWidth, childHeight);
        }
        return bitmap;
    }
}
