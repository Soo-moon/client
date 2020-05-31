package DnM.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class Reinforce extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinforce);

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