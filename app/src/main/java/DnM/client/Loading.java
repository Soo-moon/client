package DnM.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ImageView load = findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(load);
        Glide.with(this).load(R.drawable.load).into(gifImage);

        final Network network = new Network();
        network.start();
        try {
            network.join();

        } catch (InterruptedException e) {
            Log.d("error", "접속 오류" + e.getClass().getName() + ": " + e.getMessage());
        }

//        Intent intent = new Intent(getApplicationContext(), Main.class);
//        startActivity(intent);
//        finish();



    }
}