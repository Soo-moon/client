package DnM.client;

import android.util.Log;

import java.io.ObjectInputStream;
import java.net.Socket;

import shared.Player;

public class Data_In extends Thread  {
    Socket socket ;

    public Data_In(Socket socket){
        this.socket =socket;
    }

    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Log.d("conn","start");
                Player player = (Player)objectInputStream.readObject();
                Log.d("conn","end");
                Log.d("conn", player.toString());
                /*if (msg.equals("end")) {
                    break;
                }*/
            }
        } catch (Exception e) {
            Log.d("conn", "in " + e.toString());
        }
    }
}
