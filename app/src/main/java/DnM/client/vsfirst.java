package DnM.client;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import Naver.Login;
import shared.Obj;

public class vsfirst extends AppCompatActivity {

    public static Context context;
    public static View layout;
    public static PopupWindow pwindo ;
    public static int mWidthPixels, mHeightPixels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);
        int mWidthPixels, mHeightPixels;

        context = this;
        Login.network.Send(new Obj("" , 0));

        ImageView load = findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(load);
        Glide.with(this).load(R.drawable.loading).into(gifImage);

        WindowManager w = getWindowManager();
        Display d = w.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        d.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;

        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17)
            try {
                mWidthPixels = (int) Display.class.getMethod("getRawWidth").invoke(d);
                mHeightPixels = (int) Display.class.getMethod("getRawHeight").invoke(d);
            } catch (Exception ignored) {
            }
        if (Build.VERSION.SDK_INT >= 17)
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(d, realSize);
                mWidthPixels = realSize.x;
                mHeightPixels = realSize.y;
            } catch (Exception ignored) {
            }

        LayoutInflater inflater = (LayoutInflater) vsfirst.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        layout = inflater.inflate(R.layout.activity_vsmatching, (ViewGroup) findViewById(R.id.popup));

        ImageView imageView= layout.findViewById(R.id.gif_image);


        GlideDrawableImageViewTarget gifImage2 = new GlideDrawableImageViewTarget(imageView);
        Glide.with(getApplicationContext()).load(R.drawable.reinforcesucces).into(gifImage2);

        pwindo = new PopupWindow(layout, mWidthPixels - 100, mHeightPixels - 500, true);

    }

    @Override
    protected void onStop() {
        pwindo.dismiss();
        finish();
        super.onStop();
    }
}
