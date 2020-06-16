package DnM.client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {


private RelativeLayout RelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyorsell);

        RelativeLayout = findViewById(R.id.relative);

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);
    }


    public void recruitment (View view){
        Intent intent = new Intent(getApplicationContext(), BuyorSell.class);
        startActivity(intent);
    }
    public void emission (View view){
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
    }
}