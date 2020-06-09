package DnM.client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import Naver.Login;
import shared.Player;

public class Userinfo extends AppCompatActivity {
    private RelativeLayout RelativeLayout;
    ImageView imageview;
    Button button;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        RelativeLayout = findViewById(R.id.relative);
        listView = findViewById(R.id.userinfo_listview);


        //내 정보 <- 팀데이터 리스트뷰에 담기
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Main.myteam) ;
        listView.setAdapter(adapter);
        Log.d("test",  "리스트뷰");

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);

        imageview = findViewById(R.id.userinfo_imageView);
        button = findViewById(R.id.button);

        }

    public void userinfo_profilebtn(View view){              //프로필 사진 변경 클릭시
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    public void userinfo_profileimage(View view){             //프로필 이미지 클릭시
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {    //갤러리 연동
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    imageview.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void userinfo_exit(View view){
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
    }

}
