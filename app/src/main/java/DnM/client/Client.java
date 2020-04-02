package DnM.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import shared.Player;

public class Client extends AppCompatActivity {

    Network network = new Network();
    //메인 -> 네트워크쓰레드
    //네트워크쓰레드 -> 데이터 송신쓰레드 ( 서버는 먼저 클라이언트한테 갑자기보낼 데이터가 없을것으로 예상 (처음연결제외) 송신쓰레드가 수신쓰레드를 켜줌 )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        network.start();
        try {
            network.join();
        } catch (InterruptedException e) {

        }

        network.Send("request data");
        Player player = new Player("sk","최승준","지명",18,84,73,80,0,0,0);
        network.Send(player);


    }
}
