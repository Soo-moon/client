package DnM.client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class test extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    //버튼
    public void mOnPopupClick(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, poup.class);
        intent.setType("image/gif/*");
        startActivityForResult(intent, 1);
        //바보


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                ImageView imageView = findViewById(R.id.imgResult);
                imageView.setImageResource(R.drawable.reinforcesucces);

                GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(R.drawable.reinforcesucces).into(gifImage);
            }
        }
    }
}
