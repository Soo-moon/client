package DnM.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyorsell);
    }


    public void buy (View view){
        Intent intent = new Intent(getApplicationContext(), BuyorSell.class);
        startActivity(intent);
        finish();
    }


    public void sell (View view){
        Intent intent = new Intent(getApplicationContext(), Userinfo.class);
        startActivity(intent);
        finish();
    }
}