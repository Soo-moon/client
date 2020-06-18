package DnM.client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Naver.Login;
import shared.Obj;
import shared.Player;
import shared.UserData;

public class Main extends AppCompatActivity {

    private RelativeLayout RelativeLayout;

    public static UserData userData = new UserData();
    public static ArrayList<Player> myteam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout = findViewById(R.id.relative);

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);
    }

    public void shop(View view) {
        Intent intent = new Intent(getApplicationContext(), Shop.class);
        startActivity(intent);
    }

    public void reinforce(View view) {
        Intent intent = new Intent(getApplicationContext(), Reinforce.class);
        startActivity(intent);
    }

    public void userinfo(View view) {
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
    }

    public void vs(View view) {
        Intent intent = new Intent(getApplicationContext(), vstest.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        userData.setTeamdata(Main.myteam);
        Login.network.Send(new Obj(userData, 2));
        super.onDestroy();
    }

}