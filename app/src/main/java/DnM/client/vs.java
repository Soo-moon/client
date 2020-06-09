package DnM.client;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import java.io.ObjectOutputStream;

import Network.Network;
import Network.Data_out;


public class vs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);


        ObjectOutputStream out = Network.oout;


    }
}
