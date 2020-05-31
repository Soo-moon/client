package DnM.client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class Userinfo extends AppCompatActivity {

    ImageView imageview;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

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

/*
    //유저정보
    String [] Myteam = null;
    int Score = 0 ;
    String Rank = null;
    String Nickname = null;

    public Userinfo(String[] Myteam , int Score , String Rank , String Nickname){
        this.Myteam = Myteam;
        this.Score = Score;
        this.Nickname = Nickname;
        this.Rank = Rank;
    }

    public String[] getTeam(){
        return Myteam;
    }


    public int getScore(){
        return Score;
    }

    public String getNickname(){
        return Nickname;
    }

    public String getRank(){
        return Rank;
    }


    public void setScore(int Score){
       this.Score = Score;

    }

    public void setNickname(String Nickname){
        this.Nickname = Nickname;
    }

    public void setRank(String Rank){
        this.Rank=Rank;
    }

    public void setMyteam(String[] Myteam){
        this.Myteam=Myteam;
    }
   */

}
