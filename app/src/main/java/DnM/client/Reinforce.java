package DnM.client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


import androidx.appcompat.app.AppCompatActivity;

public class Reinforce extends AppCompatActivity {

    private RelativeLayout RelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinforce);

        RelativeLayout = findViewById(R.id.relative);

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);

    }
    public void reinforce_mycard(View view) {
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
    }
    public void reinforce_exit(View view){
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
    }

    public void reinforce(View view){
        //강화조건문
        // 성공시gif, 실패시gif activity 보여준 후 3초뒤 다시 activity_reinforce로 back
    }

}