package DnM.client;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import shared.Player;

public class Data_out extends Thread {
    Socket socket;
    ObjectOutputStream out = null;

    int checkcode=0;
    ArrayList<Player> arrayList ;
    String Message = null;


    public Data_out(Socket socket, String Message) {
        this.socket = socket;
        this.Message = Message;
    }

    public Data_out(Socket socket, ArrayList<Player> arrayList, int checkcode) {
        this.socket = socket;
        this.arrayList = arrayList;
        this.checkcode = checkcode;
    }



    public  void SendMessage() throws IOException {
            if (checkcode == 1){
                out.writeObject(arrayList);
                out.flush();
                Log.d("send","array");
            }
            else{
                out.writeObject(Message);
                out.flush();
                Log.d("send",Message);
            }
    }

    //이 부분이 수신쓰레드 키는 부분
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            SendMessage();
           // Log.d("send",Message);
           // Data_In data_in = new Data_In(socket);
           // data_in.start();
           // data_in.join();
        } catch (Exception e) {
            Log.d("error","senderror"+e.toString());
        }
    }
}
