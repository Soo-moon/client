package Network;

import android.util.Log;


import java.io.IOException;
import java.io.ObjectInputStream;

import DnM.client.BuyorSell;
import DnM.client.Main;
import DnM.client.Shop;
import shared.Obj;

public class Data_In extends Thread {

    ObjectInputStream oin;


    public Data_In(ObjectInputStream oin) {
        this.oin = oin;
    }

    public void run() {
        try {
            boolean end = true;
            while (end) {
                Log.d("test", "대기");
                Obj obj = (Obj) oin.readObject();
                Log.d("test", "수신");

                int code = obj.getcode();

                switch (code) {

                    case 0:
                        Main.userData = obj.getUserData();
                        break;

                    case 1:
                        final String message = obj.getstr();
                        if (message.equals("/end")) end = false;
                        Log.d("test",  message);

                        break;

                    case 2:
                        Main.myteam = obj.getarray();
                        break;

                    case 3:
                        BuyorSell.SearchData = obj.getarray();
                        break;
                }

            }
        } catch (Exception e) {
            Log.d("conn", "in " + e.toString());
        } finally {
            try {
                oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
