package Network;

import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Naver.Login;
import shared.Obj;

public class Network extends Thread {
    Socket socket;
    public static ObjectOutputStream oout;
    public static ObjectInputStream oin;
    String localhost = "192.168.55.133";



    //소켓 설정
    public void run() {
        try {

            socket = new Socket(localhost, 5550);
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

