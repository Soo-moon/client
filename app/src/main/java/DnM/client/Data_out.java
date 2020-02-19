package DnM.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Data_out extends Thread {
    Socket socket;
    String Message;
    DataOutputStream out = null;

    public Data_out(Socket socket, String Message){
        this.socket = socket;
        this.Message= Message;
    }

    public void SendMessage() throws IOException {
        out.writeUTF(Message);
        out.flush();
    }

    public void run() {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            SendMessage();
        } catch (Exception e) {
        }
    }
}
