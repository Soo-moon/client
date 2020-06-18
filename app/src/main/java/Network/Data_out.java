package Network;

import android.util.Log;

import java.io.ObjectOutputStream;


import shared.Obj;

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
            Log.d("test", "서버 전송 코드: "+object.getcode());

        } catch (Exception e) {
            Log.d("error", "Send error " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
