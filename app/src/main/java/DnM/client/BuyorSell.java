package DnM.client;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import Naver.Login;
import mFragment.mPage1;
import mFragment.mPage2;
import mFragment.mPage3;
import shared.Obj;
import shared.Player;


public class BuyorSell extends AppCompatActivity {

    private RelativeLayout RelativeLayout;

    public static ArrayList<Player> SearchData = new ArrayList<>();

    EditText editText;
    int position1 = 0;

    public static int id_arr[];
    public static TextView CountView = null;
    public static ImageButton NextButton = null;
    public static ImageButton BackButton = null;
    public static Context mContext;

    public static FragmentManager fm;

    Fragment fr;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        CountView = findViewById(R.id.count);
        NextButton = findViewById(R.id.shop_next);
        BackButton = findViewById(R.id.shop_back);

        mContext = this;

        RelativeLayout = findViewById(R.id.relative);
        editText = findViewById(R.id.shop_search_text);

        Spinner spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                position1 = position;
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

    public void shop_search(View view) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                defultView();
            }
        });

        String str = editText.getText().toString();

        if (position1 == 0) {
            Login.network.Send(new Obj(str, 4));
        } else if (position1 == 1) {
            Login.network.Send(new Obj(str, 3));
        }

        //서버와 통신시간 고려 , 딜레이 핸들러 호출
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //프레그먼트 전환 코드 작성
                        fr = new mPage1();
                        SelectPage(fr);
                        //검색데이터 크기에 따른 표시
                        if (SearchData.size() > 9 && SearchData.size() < 18) {
                            CountView.setText("1/2");
                            NextButton.setVisibility(View.VISIBLE);
                        } else if (SearchData.size() > 18) {
                            CountView.setText("1/3");
                            NextButton.setVisibility(View.VISIBLE);
                        } else {
                            CountView.setText("1/1");
                        }
                    }
                });
            }
        }, 500);

    }

    public void shop_exit(View view) {
        finish();
    }

    public void next(View view) {
        String count = CountView.getText().toString().substring(0, 1);
        int PageNum = Integer.parseInt(count);
        int EndPage = Integer.parseInt(CountView.getText().toString().substring(2, 3));

        BackButton.setVisibility(View.VISIBLE);

        switch (PageNum) {
            case 1:
                if (EndPage == 3)
                    CountView.setText("2/3");
                else{
                    CountView.setText("2/2");
                    NextButton.setVisibility(View.INVISIBLE);
                }
                fr = new mPage2();
                SelectPage(fr);
                break;
            case 2:
                CountView.setText("3/3");
                NextButton.setVisibility(View.INVISIBLE);
                fr = new mPage3();
                SelectPage(fr);
                break;
        }
    }

    public void shop_back(View view){
        String counet = CountView.getText().toString().substring(0,1);
        int PageNum = Integer.parseInt(counet);
        int EndPage =  Integer.parseInt(CountView.getText().toString().substring(2));

        NextButton.setVisibility(View.VISIBLE);

        switch (PageNum){
            case 2:
                if(EndPage == 3){
                    CountView.setText("1/3");
                }
                else
                    CountView.setText("1/2");
                BackButton.setVisibility(View.INVISIBLE);
                fr=new mPage1();
                SelectPage(fr);
                break;
            case 3:
                CountView.setText("2/3");
                fr=new mPage2();
                SelectPage(fr);
                break;
        }
    }

    public static Drawable ImageSet(int index) {
        if (SearchData.size() == 0){
            System.out.println("없음");
        }
        Player player= SearchData.get(index);

        String position_type = player.getType();

        int num = new Random().nextInt(3);
        // drawable 데이터 비교 코드 작성
        Drawable drawable = null;
            switch (position_type) {
                case "투수":
                    switch (num) {
                        case 0:
                            drawable = mContext.getResources().getDrawable(R.drawable.xntn1);
                            break;
                        case 1:
                            drawable = mContext.getResources().getDrawable(R.drawable.xntn2);
                            break;
                        case 2:
                            drawable = mContext.getResources().getDrawable(R.drawable.xntn3);
                    }
                    break;
                case "포수":
                    switch (num) {
                        case 0:
                            drawable = mContext.getResources().getDrawable(R.drawable.vhtn1);
                            break;
                        case 1:
                            drawable = mContext.getResources().getDrawable(R.drawable.vhtn2);
                            break;
                        case 2:
                            drawable = mContext.getResources().getDrawable(R.drawable.vhtn3);
                    }
                    break;
                case "타자":
                    switch (num) {
                        case 0:
                            drawable = mContext.getResources().getDrawable(R.drawable.xkwk1);
                            break;
                        case 1:
                            drawable = mContext.getResources().getDrawable(R.drawable.xkwk2);
                            break;
                        case 2:
                            drawable = mContext.getResources().getDrawable(R.drawable.xkwk3);
                    }
                    break;
            }

        return drawable;
    }

    public void SelectPage(Fragment fr) {
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.shop_page, fr);
        fragmentTransaction.commit();
    }

    public void defultView() {
        NextButton.setVisibility(View.INVISIBLE);
        BackButton.setVisibility(View.INVISIBLE);
        CountView.setText("1/1");
    }

    public static String[] Dataset(int index){
        Player player = SearchData.get(index);
        String position_type = player.getType();
        String[] message = new String[2];
        if(position_type.equals("투수")){
            message[0] = player.name;
            message[1] = "체력: "+player.health + "\n제구: "+player.Control + "\n구속: "+player.ballspeed;
            return message;
        }
        else {
            message[0] = player.name;
            message[1] = "파워: "+player.power + "\n컨디션: "+player.Condition + "\n속도: "+player.speed;
            return message;
        }
    }

    public static Player playerget(int index){
        Player player = SearchData.get(index);
        return player;
    }




}



