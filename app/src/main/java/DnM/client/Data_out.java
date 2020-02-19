package DnM.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Data_out extends Thread {
    Socket socket=null;
    boolean first = true;
    DataOutputStream out =null;

    public Data_out(Socket socket){
        this.socket=socket;
    }

    public void write(String str) throws IOException {
        out.writeUTF(str);
        out.flush();
    }

    public void run(){
        try {
            out = new DataOutputStream(socket.getOutputStream());

            if(first){
                write("request data");
                first = false;
            }



        }
        catch (Exception e) {
        }
    }
}
