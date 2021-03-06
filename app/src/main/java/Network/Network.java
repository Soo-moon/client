package Network;

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
    public static Socket socket;
    public static ObjectOutputStream oout;
    public static ObjectInputStream oin;

    String localhost = "192.168.55.133";
    String serverip ="222.236.118.4";

    //소켓 설정
    public void run() {
        try {

            socket = new Socket(localhost, 5550);
            oout = new ObjectOutputStream(socket.getOutputStream());
            Send(new Obj(Login.userData,10));
            oin = new ObjectInputStream(socket.getInputStream());
            recv();

        } catch (Exception e) {
            Log.d("error","Network error " + e.getClass().getName() +": " + e.getMessage());
        }
    }

    public static void Send(Obj object){
        Data_out data_out = new Data_out(oout, object);
        data_out.start();

    }

    public void recv(){
        Data_In data_in = new Data_In(oin);
        data_in.start();
    }



}

