package DnM.client;

import android.util.Log;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Naver.Login;
import shared.Obj;
import shared.Player;
import shared.UserData;

import static Naver.Login.personalid;

public class Network extends Thread {
    Socket socket;
    public static ObjectOutputStream oout;
    public static ObjectInputStream oin;



    //소켓 설정
    public void run() {
        try {

            socket = new Socket("192.168.55.133", 6000);
            oout = new ObjectOutputStream(socket.getOutputStream());
            Send(new Obj(Login.userData,0));
            oin = new ObjectInputStream(socket.getInputStream());
            recv();

        } catch (Exception e) {
            Log.d("error","Network error " + e.getClass().getName() +": " + e.getMessage());
        }
    }

    public void Send(Obj object){
        Data_out data_out = new Data_out(oout, object);
        data_out.start();
    }

    public void recv(){
        Data_In data_in = new Data_In(oin);
        data_in.start();
    }



}

