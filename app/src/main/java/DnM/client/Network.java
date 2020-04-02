package DnM.client;

import android.util.Log;
import java.net.Socket;

import shared.Player;

public class Network extends Thread {
    Socket socket=null;

    public void run() {
        try {
            socket = new Socket("172.30.1.43", 5000);

        } catch (Exception e) {
            Log.d("conn","run error" + e.toString());
        }
    }

    public void Send(String Message){
        Data_out data_out = new Data_out(socket,Message);
        data_out.start();
    }

    public void Send(Player player){
        Data_out data_out = new Data_out(socket,player);
        data_out.start();
    }

}

