package DnM.client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private RelativeLayout RelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout = findViewById(R.id.relative);

        Drawable draw = getResources().getDrawable(R.drawable.main1);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);
    }
    public void shop(View view){
        Intent intent = new Intent(getApplicationContext(), Shop.class);
        startActivity(intent);
        finish();
    }
    public void reinforce(View view){
        Intent intent = new Intent(getApplicationContext(), Reinforce.class);
        startActivity(intent);
        finish();
    }
    public void userinfo(View view){
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
        finish();
    }
    public void vs(View view){
        Intent intent = new Intent(getApplicationContext(), VS.class);
        startActivity(intent);
        finish();
    }
}