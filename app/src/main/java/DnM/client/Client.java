package DnM.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import shared.Player;

public class Client extends AppCompatActivity {

    Network network = new Network();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        network.start();

        try {
            network.join();

        } catch (InterruptedException e) {

        }



     //   network.Send("request");
        Player player = new Player("sk","최승준","지명",18,84,73,80,0,0,0);
        Player player2 = new Player("sk","김성현","1루수",18,70,97,72,0,0,0);
        Player player3 = new Player("sk","정은원","2루수",18,86,87,93,0,0,0);
        Log.d("send","player");

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player);
        playerArrayList.add(player2);
        playerArrayList.add(player3);
        Log.d("send","player list");

        network.Send(playerArrayList);
        Log.d("send","server");

        // 서버로 여러 플레이어 데이터 보내기 -> 성공
        // object 형태로 보내려 했으나 에러



    }
}
