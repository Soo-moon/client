package DnM.client;

import android.util.Log;

import java.io.DataInputStream;
import java.net.Socket;

public class Data_In extends Thread {
    Socket socket =null;

    public Data_In(Socket socket){
        this.socket =socket;
    }

    public void run(){
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                String msg = dataInputStream.readUTF();
                Log.d("conn", msg);
                if (msg.equals("stop")) {
                    break;
                }
            }
        } catch (Exception e) {
            Log.d("conn", "in " + e.toString());
        }
    }
}
