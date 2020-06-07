package DnM.client;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import shared.Player;

import Naver.Login;
import shared.Obj;

public class BuyorSell extends AppCompatActivity {

    private RelativeLayout RelativeLayout;

    public static ArrayList<Player> SearchData = new ArrayList<>();

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

       final int position;

        RelativeLayout = findViewById(R.id.relative);
        editText = findViewById(R.id.shop_search_text);

        Spinner spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Drawable draw = getResources().getDrawable(R.drawable.main);
        draw.setAlpha(70);
        RelativeLayout.setBackgroundDrawable(draw);
    }

    public void shop_buy(View view) {
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("구매 재차확인");
            builder.setMessage("구매하시겠습니까?");
            builder.setPositiveButton("예",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "예를 선택했습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
            builder.setNegativeButton("아니오",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "아니오를 선택했습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
            builder.show();
        }
    }
    public  void shop_search(View view){

    }
    public void shop_exit(View view){
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
        finish();
    }

    public void next(View view){

    }
    public void image1(View view){
        Button btn = findViewById(R.id.shop_search_image);
        btn.setFocusable(true);
    }
}
