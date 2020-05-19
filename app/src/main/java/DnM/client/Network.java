package DnM.client;

import android.util.Log;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import shared.Obj;
import shared.Player;

public class Network extends Thread {
    Socket socket;
    ObjectOutputStream oout;
    OutputStream out;

    //소켓 설정
    public void run() {
        try {
            socket = new Socket("192.168.55.133", 6000);
            out = socket.getOutputStream();
            oout = new ObjectOutputStream(out);
            sleep(2000);


        } catch (Exception e) {
            Log.d("error","Network error " + e.getClass().getName() +": " + e.getMessage());
        }
    }

    public void Send(Obj object){
        Data_out data_out = new Data_out(oout, object);
        data_out.start();
    }



}

