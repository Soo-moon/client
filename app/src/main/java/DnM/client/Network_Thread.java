package DnM.client;

import android.util.Log;
import java.net.Socket;

public class Network_Thread extends Thread {

    Data_In data_in = null;
    Data_out data_out = null;
    Socket socket=null;

    public void run() {
        try {

            socket = new Socket("172.30.1.43", 5000);
            data_out = new Data_out(socket);
            data_out.start();

            data_in = new Data_In(socket);
            data_in.start();

        } catch (Exception e) {
            Log.d("conn","run error" + e.toString());
        }
    }
}

