package DnM.client;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import java.util.logging.LogRecord;

import Naver.Login;
import shared.Obj;
import shared.Player;

public class Data_In extends Thread  {

    ObjectInputStream oin;


    public Data_In(ObjectInputStream oin ){
        this.oin = oin;
    }

    public void run() {
        try {
            boolean end = true;
            while (end) {
                Log.d("test","대기");
                Obj obj = (Obj) oin.readObject();
                Log.d("test","수신");

                int code = obj.getcode();

                switch (code){

                    case 0:
                        Main.userData = obj.getUserData();
                        break;

                    case 1:
                        final String message = obj.getstr();
                        if (message.equals("/end")) end =false;
//                        Handler mHandler = new Handler(Looper.getMainLooper());
//                        mHandler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(Login.mContext,"서버 수신 : "+message,Toast.LENGTH_SHORT).show();
//                            }
//                        });
                        //메세지 송신 완료
                        //toast 메세지 activity 전환 도중 씹힘 

                        break;

                    case 2:
                        Main.myteam = obj.getarray();
                        break;
                }

            }
        } catch (Exception e) {
            Log.d("conn", "in " + e.toString());
        }

        finally {
            try {
                oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
