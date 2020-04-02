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
