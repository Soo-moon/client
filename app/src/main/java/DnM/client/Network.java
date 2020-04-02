package DnM.client;

import android.util.Log;
import java.net.Socket;

import shared.Player;

public class Network extends Thread {
    Socket socket=null;

    //소켓 설정
    public void run() {
        try {
            socket = new Socket("172.30.1.43", 5000);

        } catch (Exception e) {
            Log.d("conn","run error" + e.toString());
        }
    }

    //송신쓰레드에 String 인자 전달
    //message 는 최초 데이터 요청메세지 (ex; 내 정보 팀데이터 ) <- 로컬(사용자 핸드폰) 에 데이터를 저장하고 서버 db에도 저장해서 서로 비교하는방식으로 구상중 (미정)
    public void Send(String Message){
        Data_out data_out = new Data_out(socket,Message);
        data_out.start();
    }


    //(임시상태) Player 란 클래스를 소켓에서 전송중
    public void Send(Player player){
        Data_out data_out = new Data_out(socket,player);
        data_out.start();
    }

}

