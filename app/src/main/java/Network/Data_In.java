package Network;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;

import DnM.client.BuyorSell;
import DnM.client.Main;
import DnM.client.vs;
import DnM.client.vstest;
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

                int code = obj.getcode();

                switch (code) {
                    //내 정보 초기화
                    case 100:
                        Main.myteam = obj.getUserData().getTeamdata();
                        Main.userData = obj.getUserData();
                        Log.d("test", "UserData 수신");
                        break;
                    //서버 메세지
                    case 101:
                        String message = obj.getstr();
                        Log.d("test", message);
                        break;
                    // 내 팀 변경
                    case 102:
                        Main.myteam = obj.getUserData().getTeamdata();
                        Log.d("test", "myteam 변경");
                        break;
                    //쿼리 검색 수신
                    case 103:
                        BuyorSell.SearchData = obj.getarray();
                        Log.d("test", String.valueOf(obj.getarray().size()));
                        break;
                    case 110:
                        vs.result = obj.getstr() + "님 과 대결에서 승리 하였습니다 " ;
                        Intent intent = new Intent(vstest.context , vs.class);
                        vstest.context.startActivity(intent);
                        break;
                    case 111:
                        vs.result = obj.getstr() + "님 과 대결에서 패배 하였습니다 " ;
                        Intent intent2 = new Intent(vstest.context , vs.class);
                        vstest.context.startActivity(intent2);
                        break;

                    //통신 종료
                    case 999:
                        Log.d("test","종료 패킷");
                        end = false;
                        break;

                }

            }
        } catch (Exception e) {
            Log.d("conn", "in " + e.toString());
        } finally {
            try {
                Log.d("test", "종료");
                oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
