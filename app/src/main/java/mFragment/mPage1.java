package mFragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;

import DnM.client.BuyorSell;
import DnM.client.R;
import DnM.client.Reinforce;
import shared.Player;

public class mPage1 extends Fragment {

    static ArrayList<Player> SearchPlayerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.page , container , false);
        SearchPlayerList = BuyorSell.SearchData;

        int id_arr[] = new int[]{R.id.shop_search_image, R.id.shop_search_image1, R.id.shop_search_image2, R.id.shop_search_image3
                , R.id.shop_search_image4, R.id.shop_search_image5, R.id.shop_search_image6, R.id.shop_search_image7,
                R.id.shop_search_image8};



        for (int i = 0; i < 9; i++) {
                Button btn = view.findViewById(id_arr[i]);
                btn.setVisibility(View.VISIBLE);
                btn.setBackground(BuyorSell.ImageSet(i));
        }

        return view;
    }

/*  public void Card_click(View view){
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

    private void initiatePopupWindow() {
        try {
            LayoutInflater inflater = (LayoutInflater) Reinforce.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.activity_popup, (ViewGroup) findViewById(R.id.popup));

            pwindo = new PopupWindow(layout, mWidthPixels - 100, mHeightPixels - 500, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            btnClosePopup = layout.findViewById(R.id.btn_close);
            btnClosePopup.setOnClickListener(cancel_button_click_listner);



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
    }*/
}
