package DnM.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import shared.Obj;
import shared.Player;

public class Client extends AppCompatActivity {
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);

        Button btn = findViewById(R.id.test);

        final Network network = new Network();
        network.start();
        try {
            network.join();

        } catch (InterruptedException e) {
            Log.d("error", "접속 오류" + e.getClass().getName() + ": " + e.getMessage());
        }


        final Obj obj1 = new Obj("request", 1);
     //   network.Send(obj1);


        Player player = new Player("sk", "최승준", "지명", 18, 84, 73, 80, 0, 0, 0);
        Player player2 = new Player("sk", "김성현", "1루수", 18, 70, 97, 72, 0, 0, 0);
        Player player3 = new Player("sk", "정은원", "2루수", 18, 86, 87, 93, 0, 0, 0);

        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(player);
        playerArrayList.add(player2);
        playerArrayList.add(player3);

       final Obj obj2 = new Obj(playerArrayList, 2);
        network.Send(obj2);

       final Obj obj3 = new Obj("/end", 1);
      //  network.Send(obj3);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time == 0) {
                    network.Send( obj1);
                    time++;
                    Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                }
                else if(time ==1){
                    network.Send(obj2);
                    time++;
                    Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                }
                else if(time == 2){
                    network.Send(obj3);
                    time++;
                    Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                }

            }
        });






    }
}
