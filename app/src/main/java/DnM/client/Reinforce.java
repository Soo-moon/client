package DnM.client;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class Reinforce extends Activity {
    private RelativeLayout RelativeLayout;
    ImageView imageView;
    private Button btnClosePopup;
    private Button btnCreatePopup;
    private PopupWindow pwindo;
    private int mWidthPixels, mHeightPixels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reinforce);
        RelativeLayout = findViewById(R.id.relative);

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);

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
        btnCreatePopup = findViewById(R.id.btn1);
        btnCreatePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initiatePopupWindow();
            }
        });

    }

    public void reinforce_mycard(View view) {
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
    }
    public void reinforce_exit(View view){
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
    }

    private void initiatePopupWindow() {
        try {
            LayoutInflater inflater = (LayoutInflater) Reinforce.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.activity_popup, (ViewGroup) findViewById(R.id.popup));

            pwindo = new PopupWindow(layout, mWidthPixels - 100, mHeightPixels - 500, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            btnClosePopup = layout.findViewById(R.id.btn_close);
            btnClosePopup.setOnClickListener(cancel_button_click_listner);

            imageView = layout.findViewById(R.id.gif_image);
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(imageView);
            Glide.with(this).load(R.drawable.reinforcesucces).into(gifImage);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener cancel_button_click_listner = new View.OnClickListener() {
        public void onClick(View view) {
            pwindo.dismiss();
        }
    };


    //확인 버튼 클릭
    public void mOnClose(View v) {
        //데이터 전달하기
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }


}
