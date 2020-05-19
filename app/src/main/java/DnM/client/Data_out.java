package DnM.client;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import shared.Obj;
import shared.Player;

public class Data_out extends Thread {

    Obj object;
    ObjectOutputStream outputStream;

    public Data_out(ObjectOutputStream outputStream, Obj object) {
        this.object = object;
        this.outputStream = outputStream;
    }

    public void run() {
        try {
            outputStream.writeObject(object);
            outputStream.flush();


        } catch (Exception e) {
            Log.d("error", "Send error " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
