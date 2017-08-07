package io.haydar.supercircle.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by 明正 on 2017/8/6.
 */

public class ScreenshotsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenshots);
        ImageView imageView = (ImageView) findViewById(R.id.img_timg);
        ImageView imageView1 = (ImageView) findViewById(R.id.img_timg1);
        Bitmap bitmap = ScreenshotsUiUtils.getIntence().screenshotsWindow(this);
        if (bitmap != null) {
            imageView1.setImageBitmap(bitmap);
        }
    }
}
