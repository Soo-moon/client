package DnM.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import shared.Player;

public class Data_out extends Thread {
    Socket socket;
    String Message = null;
    ObjectOutputStream out = null;
    Player player =null;

    public Data_out(Socket socket, String Message) {
        this.socket = socket;
        this.Message = Message;
    }

    public Data_out(Socket socket, Player player) {
        this.socket = socket;
        this.player = player;
    }

    public void SendMessage() throws IOException {
        if (Message != null) {
            out.writeUTF(Message);
            out.flush();
        }
        if(player != null){
            out.writeObject(player);
            out.flush();
        }

    }

    //이 부분이 수신쓰레드 키는 부분
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            SendMessage();
            Data_In data_in = new Data_In(socket);
            data_in.start();
            data_in.join();
        } catch (Exception e) {
        }
    }
}
